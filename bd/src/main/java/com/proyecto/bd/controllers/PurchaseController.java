package com.proyecto.bd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.Purchase;
import com.proyecto.bd.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    
    @Autowired
    private PurchaseService purchaseService;

    // Obtener todas las marcas
    @GetMapping
    public List<Purchase> getAllPurchase() {
        return purchaseService.getAllPurchase();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        Optional<Purchase> brand = purchaseService.getPurchasedById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase brand) {
        Purchase createdBrand = purchaseService.createPurchase(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updateInventory(@PathVariable Long id, @RequestBody Purchase updatedBrand) {
        try {
            Purchase brand = purchaseService.updatePurchase(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        try {
            purchaseService.deletePurchase(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
