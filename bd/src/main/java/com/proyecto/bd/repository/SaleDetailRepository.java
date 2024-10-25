package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.SalesDetail;

public interface SaleDetailRepository extends CrudRepository<SalesDetail, Long>{

    List<SalesDetail> findAll();

}
