package mx.seg.ipn.aplicacion.seguridad.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.seg.ipn.aplicacion.seguridad.infrastructure.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

}
