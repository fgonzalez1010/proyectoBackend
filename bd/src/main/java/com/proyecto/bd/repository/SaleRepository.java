package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {
    List<Sale> findAll();
    List<Sale> findByUserClient_ClientId(Long clientId);

}
