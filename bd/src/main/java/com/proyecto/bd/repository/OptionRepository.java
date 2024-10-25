package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.OptionTable;

public interface OptionRepository extends CrudRepository<OptionTable, Long>{

    List<OptionTable> findAll();

}
