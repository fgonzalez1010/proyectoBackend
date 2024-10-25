package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.ProductLine;

public interface LineRepository extends CrudRepository<ProductLine, Long> {

    List<ProductLine> findAll();

}
