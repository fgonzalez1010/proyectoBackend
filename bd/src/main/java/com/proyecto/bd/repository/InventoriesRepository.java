package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Inventory;

public interface InventoriesRepository extends CrudRepository<Inventory, Long> {
    List<Inventory> findAll();

}
