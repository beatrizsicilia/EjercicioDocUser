package com.maria.ejercicio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.maria.ejercicio.model.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long>{
    public Optional<User> findById(Long id);
    
}
