package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.UserTable;

public interface UserRepository extends CrudRepository<UserTable, Long> {

    List<UserTable> findAll();

}
