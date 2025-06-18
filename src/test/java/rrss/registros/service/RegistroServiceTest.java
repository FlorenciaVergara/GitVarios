package rrss.registros.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import rrss.registros.model.Registro;
import rrss.registros.model.TipoRegistro;
import rrss.registros.repository.RegistroRepository;
import rrss.registros.repository.TipoRegistroRepository;

@ExtendWith(MockitoExtension.class) // Habilita el soporte de Mockito
public class RegistroServiceTest {

    @Mock
    private RegistroRepository registroRepository; // Mock del repositorio

    @Mock
    private TipoRegistroRepository tipoRegistroRepository;
    
    @InjectMocks
    private RegistroService registroService; // Servicio a probar

    @Test
public void testCrearRegistroConAutonumeracion() {
    System.out.println(">>> INICIO del test");
    // Simular el tipo de registro requerido
    TipoRegistro tipoMock = new TipoRegistro();
    tipoMock.setNombre("Habitualista");
    tipoMock.setRequiereAutonumeracion(true);
    tipoMock.setValorInicial(4000); // ejemplo

    // Simular que ya existe un registro anterior
    Registro ultimoRegistro = new Registro();
    ultimoRegistro.setNumero(4002); // el último número asignado

    // Registro a devolver al guardar
    Registro registroGuardado = new Registro();
    registroGuardado.setId(1L);
    registroGuardado.setNombre("Test Registro");
    registroGuardado.setDistrito("La Plata");
    registroGuardado.setTipoRegistro(tipoMock);
    registroGuardado.setNumero(4003); // esperado: último + 1

    // Simulaciones
    when(tipoRegistroRepository.findByNombre("Habitualista"))
        .thenReturn(Optional.of(tipoMock));

    when(registroRepository.findTopByTipoRegistroNombreOrderByNumeroDesc("Habitualista"))
        .thenReturn(Optional.of(ultimoRegistro));

    when(registroRepository.save(any(Registro.class)))
        .thenReturn(registroGuardado);

    // Ejecutar
    Registro resultado = registroService.crearRegistro(
        null, // fuerza autonumeración
        "Test Registro",
        "La Plata",
        "Habitualista"
    );

    // Verificaciones
    assertNotNull(resultado);
    assertEquals("Test Registro", resultado.getNombre());
    assertEquals("La Plata", resultado.getDistrito());
    assertEquals("Habitualista", resultado.getTipoRegistro().getNombre());
    assertEquals(4003, resultado.getNumero()); // 4002 + 1

    verify(registroRepository, times(1)).save(any(Registro.class));
    verify(tipoRegistroRepository, times(1)).findByNombre("Habitualista");
    verify(registroRepository, times(1)).findTopByTipoRegistroNombreOrderByNumeroDesc("Habitualista");
    
    System.out.println(">>> FIN del test");
}

@Test
public void testCrearRegistro_TipoNoEncontrado() {
    System.out.println(">>> INICIO del test de tipo no encontrado");
    // Simular que el tipo de registro no existe
    when(tipoRegistroRepository.findByNombre("Tipo Inexistente"))
        .thenReturn(Optional.empty());

    Exception exception = assertThrows(RuntimeException.class, () -> {
        registroService.crearRegistro(null, "Nombre", "Distrito", "Tipo Inexistente");
    });

    assertEquals("Tipo no encontrado: Tipo Inexistente", exception.getMessage());

    verify(tipoRegistroRepository, times(1)).findByNombre("Tipo Inexistente");
    verify(registroRepository, times(0)).save(any(Registro.class));

    System.out.println(">>> FIN del test de tipo no encontrado");
}
    
}
