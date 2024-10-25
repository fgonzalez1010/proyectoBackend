package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.UserClient;

public interface ClientRepository extends CrudRepository<UserClient, Long> {
    List<UserClient> findAll();

}
