package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
     List<PaymentMethod> findAll();

}
