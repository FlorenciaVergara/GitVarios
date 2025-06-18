package rrss.registros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rrss.registros.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long>{
     Optional<Registro> findTopByTipoRegistroNombreOrderByNumeroDesc(String nombre);

}
