package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.InventoryMovement;

public interface MovementRepository extends CrudRepository<InventoryMovement, Long> {

    List<InventoryMovement> findAll();

}
