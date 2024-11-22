package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.REPORTE;

public interface REPORTEREPOSITORY extends CrudRepository<REPORTE, String>{
 List<REPORTE> findAll();
}
