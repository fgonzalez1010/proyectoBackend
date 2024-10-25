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

import com.proyecto.bd.entities.ProductCategory;
import com.proyecto.bd.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    
    @Autowired
    private CategoryService categoryService;

    // Obtener todas las marcas
    @GetMapping
    public List<ProductCategory> getAllCategory() {
        return categoryService.getAllCategory();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getCategoryById(@PathVariable Long id) {
        Optional<ProductCategory> brand = categoryService.getCategoryById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategory brand) {
        ProductCategory createdBrand = categoryService.createCategory(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateCategory(@PathVariable Long id, @RequestBody ProductCategory updatedBrand) {
        try {
            ProductCategory brand = categoryService.updateCategory(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
