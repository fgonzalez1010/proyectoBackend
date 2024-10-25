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

import com.proyecto.bd.entities.Branch;
import com.proyecto.bd.services.BranchService;
@RestController
@RequestMapping("/branch")
public class BranchController {

    
    @Autowired
    private BranchService branchService;

    // Obtener todas las marcas
    @GetMapping
    public List<Branch> getAllBranchs() {
        return branchService.getAllBranch();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id) {
        Optional<Branch> branch = branchService.getBranchById(id);
        return branch.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch brand) {
        Branch createdBranch = branchService.createBranch(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBranch);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBrand(@PathVariable Long id, @RequestBody Branch updatedBrand) {
        try {
            Branch brand = branchService.updateBranch(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        try {
            branchService.deleteBranch(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

