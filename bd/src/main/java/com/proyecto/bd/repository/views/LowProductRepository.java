package com.proyecto.bd.repository.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.views.LowProducts;

public interface LowProductRepository extends CrudRepository<LowProducts, Long>{
 List<LowProducts> findAll();
}
