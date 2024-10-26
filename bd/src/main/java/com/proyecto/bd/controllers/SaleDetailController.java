package com.proyecto.bd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.SalesDetail;
import com.proyecto.bd.services.SaleDetailService;

@RestController
@RequestMapping("/sale-detail")
public class SaleDetailController {

     
    @Autowired
    private SaleDetailService saleDService;

    // Obtener todas las marcas
    @GetMapping
    public List<SalesDetail> getAllSalesDetail() {
        return saleDService.getAllSalesDetail();
    }


    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesDetail> getSalesDetailById(@PathVariable Long id) {
        Optional<SalesDetail> brand = saleDService.getSalesDetailById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<SalesDetail> createSalesDetail(@RequestBody SalesDetail brand) {
        SalesDetail createdBrand = saleDService.createSalesDetail(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<SalesDetail> updateSalesDetail(@PathVariable Long id, @RequestBody SalesDetail updatedBrand) {
        try {
            SalesDetail brand = saleDService.updateSalesDetail(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
