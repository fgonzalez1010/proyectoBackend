package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.bd.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAll();

}
