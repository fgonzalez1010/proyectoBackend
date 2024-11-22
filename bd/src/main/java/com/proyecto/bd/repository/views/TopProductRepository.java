package com.proyecto.bd.repository.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.views.TopProducts;

public interface TopProductRepository extends CrudRepository<TopProducts, Long>{
 List<TopProducts> findAll();
}
