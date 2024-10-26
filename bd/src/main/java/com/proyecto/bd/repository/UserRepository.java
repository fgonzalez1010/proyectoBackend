package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.bd.entities.UserTable;
@Repository
public interface UserRepository extends CrudRepository<UserTable, Long> {

    List<UserTable> findAll();
    
    List<UserTable> findByEmailAndPassword(String email, String password);
}

