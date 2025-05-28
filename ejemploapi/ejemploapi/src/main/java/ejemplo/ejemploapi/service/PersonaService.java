package ejemplo.ejemploapi.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import ejemplo.ejemploapi.model.Persona;
import ejemplo.ejemploapi.model.PersonaInfoDTO;
import ejemplo.ejemploapi.repository.PersonaRepository;

@Service
public class PersonaService {
     
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public PersonaInfoDTO obtenerInfoPersona(Persona persona) {
        // Calcular edad
        int edad = calcularEdad(persona.getFechaNacimiento());
        persona.setEdad(edad);

        Persona personaGuardada = personaRepository.findByNombre(persona.getNombre());

        String color = personaGuardada.getColor();

        persona.setColor(color);
        personaRepository.save(persona);
        return new PersonaInfoDTO(edad, color);
    }
    
    public int calcularEdad(Date fechaNacimiento) {
        LocalDate fechaNac = fechaNacimiento.toLocalDate();
        LocalDate hoy = LocalDate.now();
        return Period.between(fechaNac, hoy).getYears();
    }
}
