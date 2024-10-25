package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAll();

}
