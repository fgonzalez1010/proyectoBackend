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

import com.proyecto.bd.entities.PaymentMethod;
import com.proyecto.bd.services.PaymentMethodService;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

 @Autowired
    private PaymentMethodService paymentMethodService;

    // Obtener todas las marcas
    @GetMapping
    public List<PaymentMethod> getAllInventories() {
        return paymentMethodService.getAllpPaymentMethods();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMById(@PathVariable Long id) {
        Optional<PaymentMethod> brand = paymentMethodService.getPaymentMById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
