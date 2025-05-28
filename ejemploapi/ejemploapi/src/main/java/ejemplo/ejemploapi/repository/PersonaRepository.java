package ejemplo.ejemploapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejemplo.ejemploapi.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Persona findByNombre(String nombre);
    
}
