package com.proyecto.bd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.SalePaymentDetail;
import com.proyecto.bd.entities.SalePaymentDetailPK;
import com.proyecto.bd.services.SalePaymentDetailService;

@RestController
@RequestMapping("/sale-payment")
public class SalePaymentDetailController {

     
    @Autowired
    private SalePaymentDetailService salePaymentService;

    // Obtener todas las marcas
    @GetMapping
    public List<SalePaymentDetail> getAllInventories() {
        return salePaymentService.getAllSalePaymentDetail();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<SalePaymentDetail> getInventoryById(@PathVariable SalePaymentDetailPK id) {
        Optional<SalePaymentDetail> brand = salePaymentService.getSalePaymentDetailById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



}
