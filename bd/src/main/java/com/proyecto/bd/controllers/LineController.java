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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.ProductLine;
import com.proyecto.bd.services.LineService;

@RestController
@RequestMapping("/line")
public class LineController {
 
    @Autowired
    private LineService lineService;

    // Obtener todas las marcas
    @GetMapping
    public List<ProductLine> getAllLines() {
        return lineService.getAllLines();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductLine> getLineById(@PathVariable Long id) {
        Optional<ProductLine> brand = lineService.getLineById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<ProductLine> createLine(@RequestBody ProductLine brand) {
        ProductLine createdBrand = lineService.createLine(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        try {
            lineService.deleteLine(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}