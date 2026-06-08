package mx.seg.ipn.aplicacion.seguridad.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mx.seg.ipn.aplicacion.seguridad.infrastructure.entity.CatGenero;

public interface CatGeneroRepository  extends    
 CrudRepository<CatGenero, String> 

// JpaRepository<CatGenero, String> 
{

}
