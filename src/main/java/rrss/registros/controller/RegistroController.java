package rrss.registros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rrss.registros.dto.RegistroDTO;
import rrss.registros.model.Registro;
import rrss.registros.service.RegistroService;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping
    public ResponseEntity<Registro> crearRegistro(@RequestBody RegistroDTO dto) {
        Registro nuevo = registroService.crearRegistro( dto.getNumero(),dto.getNombre(),dto.getDistrito(), dto.getTipo());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}

