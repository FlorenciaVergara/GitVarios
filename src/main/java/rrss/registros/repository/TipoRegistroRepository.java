package rrss.registros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rrss.registros.model.TipoRegistro;

public interface TipoRegistroRepository extends JpaRepository<TipoRegistro, Long> {
    Optional<TipoRegistro> findByNombre(String nombre);
    
}

