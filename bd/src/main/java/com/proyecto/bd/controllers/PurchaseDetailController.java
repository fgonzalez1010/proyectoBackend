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

import com.proyecto.bd.entities.PurchaseDetail;
import com.proyecto.bd.services.PurchaseDetailService;

@RestController
@RequestMapping("/purchase-detail")
public class PurchaseDetailController {

    
    
    @Autowired
    private PurchaseDetailService PurchaseDService;

    // Obtener todas las marcas
    @GetMapping
    public List<PurchaseDetail> getAllPurchaseD() {
        return PurchaseDService.getAllPurchaseD();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetail> getPurchaseDById(@PathVariable Long id) {
        Optional<PurchaseDetail> brand = PurchaseDService.getPurchaseDById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<PurchaseDetail> createInventory(@RequestBody PurchaseDetail brand) {
        PurchaseDetail createdBrand = PurchaseDService.createPurchaseD(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseDetail> updatePurchasD(@PathVariable Long id, @RequestBody PurchaseDetail updatedBrand) {
        try {
            PurchaseDetail brand = PurchaseDService.updatePurchaseD(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
