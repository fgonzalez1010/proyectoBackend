package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Brand;


public interface BrandRepository extends CrudRepository<Brand, Long> {

    List<Brand> findAll();
}
