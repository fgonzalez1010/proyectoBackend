package com.proyecto.bd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.UserRole;
import com.proyecto.bd.services.RolesService;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RolesController {

    
    @Autowired
    private RolesService rolesService;

    // Obtener todas las marcas
    @GetMapping
    public List<UserRole> getAllInventories() {
        return rolesService.getAllRole();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getInventoryById(@PathVariable Long id) {
        Optional<UserRole> brand = rolesService.getRoleById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<UserRole> createInventory(@RequestBody UserRole brand) {
        UserRole createdBrand = rolesService.createRole(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        try {
            rolesService.deleteRole(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
