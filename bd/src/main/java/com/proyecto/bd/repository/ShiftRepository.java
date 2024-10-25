package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Shift;

public interface ShiftRepository extends CrudRepository<Shift, Long>{
    List<Shift> findAll ();

}
