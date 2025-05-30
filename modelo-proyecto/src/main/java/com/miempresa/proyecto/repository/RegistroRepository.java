package com.miempresa.proyecto.repository;

import com.miempresa.proyecto.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistroRepository extends JpaRepository<Registro,Integer> {
    Optional<Registro> findTopByOrderByCodigoDesc();
    Optional<Registro> findById(Integer codigo);
}
