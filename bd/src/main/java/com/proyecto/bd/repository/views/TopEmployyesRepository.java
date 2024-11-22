package com.proyecto.bd.repository.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.views.TopEmployyes;

public interface TopEmployyesRepository extends CrudRepository<TopEmployyes, Long>{
 List<TopEmployyes> findAll();
}
