package rrss.registros.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import rrss.registros.model.Registro;
import rrss.registros.model.TipoRegistro;
import rrss.registros.repository.RegistroRepository;
import rrss.registros.repository.TipoRegistroRepository;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;
    private final TipoRegistroRepository tipoRegistroRepository;

    public RegistroService(RegistroRepository registroRepository,
            TipoRegistroRepository tipoRegistroRepository) {
        this.registroRepository = registroRepository;
        this.tipoRegistroRepository = tipoRegistroRepository;
    }

    public Registro crearRegistro( Integer numero, String nombre, String distrito, String tipoNombre) {
        TipoRegistro tipo = tipoRegistroRepository.findByNombre(tipoNombre)
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado: " + tipoNombre));

        if (tipo.isRequiereAutonumeracion() && numero == null) {
            // Buscar el último número asignado y sumar 1
            Optional<Registro> ultimo = registroRepository.findTopByTipoRegistroNombreOrderByNumeroDesc(tipoNombre);
            numero = ultimo.map(r -> r.getNumero() + 1).orElse(tipo.getValorInicial()); // <-- este es el cambio clave
        }

        Registro registro = new Registro();
        registro.setNombre(nombre);
        registro.setTipoRegistro(tipo);
        registro.setNumero(numero);
        registro.setDistrito(distrito);

        return registroRepository.save(registro);
    }

}
