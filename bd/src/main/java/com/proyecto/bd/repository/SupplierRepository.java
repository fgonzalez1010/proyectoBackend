package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{

    List<Supplier> findAll();

}
