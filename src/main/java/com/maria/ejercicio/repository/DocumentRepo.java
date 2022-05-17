package com.maria.ejercicio.repository;

import com.maria.ejercicio.model.Documento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends CrudRepository<Documento,Long>{
    
}
