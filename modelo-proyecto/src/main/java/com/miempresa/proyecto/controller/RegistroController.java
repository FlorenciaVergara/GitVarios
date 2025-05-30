package com.miempresa.proyecto.controller;

import com.miempresa.proyecto.service.CodigoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final CodigoService codigoService;

    public RegistroController(CodigoService codigoService) {
        this.codigoService = codigoService;
    }

    @PostMapping
    public ResponseEntity<String> crearRegistro(@RequestBody String cuit) {
        int nuevoCodigo = codigoService.generarNuevoCodigo(cuit);
        return ResponseEntity.ok("Registro creado con código: " + nuevoCodigo);
    }

    @GetMapping("/{codigo}")
public ResponseEntity<String> obtenerCuitPorCodigo(@PathVariable int codigo) {
    String cuit = codigoService.obtenerCuitPorCodigo(codigo);
    if (cuit != null) {
        return ResponseEntity.ok("CUIT asociado: " + cuit);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("No se encontró CUIT para el código ingresado: " + codigo);
    }
}

}
