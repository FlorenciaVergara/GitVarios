package ejemplo.ejemploapi.controller;

import org.springframework.web.bind.annotation.RestController;

import ejemplo.ejemploapi.model.Persona;
import ejemplo.ejemploapi.model.PersonaInfoDTO;
import ejemplo.ejemploapi.service.PersonaService;

import java.sql.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/persona")
    public PersonaInfoDTO obtenerInfoPersona(@RequestBody Persona persona) {
        return personaService.obtenerInfoPersona(persona);
    }

    @PostMapping("/persona/query")
    public PersonaInfoDTO postMethodName(@RequestParam String nombre, @RequestParam Date fechaNacimiento) {
        Persona persona = new Persona();
        persona.setNombre(nombre);  
        persona.setFechaNacimiento(fechaNacimiento);
        
        return personaService.obtenerInfoPersona(persona);
    }
    
    
    
}
