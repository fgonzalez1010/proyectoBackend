package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    List<Purchase> findAll();

}
