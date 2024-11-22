package com.proyecto.bd.repository.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.views.TopClients;

public interface TopClientsRepository extends CrudRepository<TopClients, Long>{
 List<TopClients> findAll();
}
