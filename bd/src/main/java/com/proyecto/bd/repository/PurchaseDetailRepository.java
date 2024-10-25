package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.PurchaseDetail;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Long> {
    List<PurchaseDetail> findAll();
}
