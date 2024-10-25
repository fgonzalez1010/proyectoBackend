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

import com.proyecto.bd.entities.Sale;
import com.proyecto.bd.entities.UserClient;
import com.proyecto.bd.services.ClientService;

//test2
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Obtener todas las marcas
    @GetMapping
    public List<UserClient> getAllClients() {
        return clientService.getAllClients();
    }

    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserClient> getClientById(@PathVariable Long id) {
        Optional<UserClient> brand = clientService.getClientById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{id}/sales")
    public ResponseEntity<List<Sale>> getClientByIdSales(@PathVariable Long id) {
        List<Sale> sales = clientService.getSalesByClientId(id);
        return ResponseEntity.ok(sales);
    }


    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<UserClient> createClient(@RequestBody UserClient brand) {
        UserClient createdBrand = clientService.createClient(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<UserClient> updateClient(@PathVariable Long id, @RequestBody UserClient updatedBrand) {
        try {
            UserClient brand = clientService.updateClient(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

