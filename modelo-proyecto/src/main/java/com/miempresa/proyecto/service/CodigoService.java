package com.miempresa.proyecto.service;

import com.miempresa.proyecto.model.Registro;
import com.miempresa.proyecto.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodigoService {

    @Value("${codigo.inicial:4000}")
    private int numRegistro;

    private final RegistroRepository registroRepository;

    public CodigoService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public synchronized int generarNuevoCodigo(String cuit) {
        Optional<Registro> ultimo = registroRepository.findTopByOrderByCodigoDesc();
        int nuevoCodigo = ultimo.map(r -> r.getCodigo() + 1).orElse(numRegistro);
        registroRepository.save(new Registro(nuevoCodigo,cuit));
        return nuevoCodigo;
    }

    public String obtenerCuitPorCodigo(int codigo) {
        return registroRepository.findById(codigo)
                .map(Registro::getCuitResponsable)
                .orElse(null);
    }
}
