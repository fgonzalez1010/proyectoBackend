package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.ProductCategory;

public interface CategoryRepository extends CrudRepository<ProductCategory, Long> {

    List<ProductCategory> findAll();

}
