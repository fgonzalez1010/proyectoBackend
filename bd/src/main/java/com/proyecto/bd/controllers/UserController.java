package com.proyecto.bd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.UserTable;
import com.proyecto.bd.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

     
    @Autowired
    private UserService userService;

    // Obtener todas las marcas
    @GetMapping
    public List<UserTable> getAllUserTable() {
        return userService.getAllUser();
    }


    // Obtener una marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserTable> getUserById(@PathVariable Long id) {
        Optional<UserTable> brand = userService.getUserById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<UserTable> createUser(@RequestBody UserTable brand) {
        UserTable createdBrand = userService.createUser(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
    }

    // Actualizar una marca existente
    @PutMapping("/{id}")
    public ResponseEntity<UserTable> updateUser(@PathVariable Long id, @RequestBody UserTable updatedBrand) {
        try {
            UserTable brand = userService.updateUser(id, updatedBrand);
            return ResponseEntity.ok(brand);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar una marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping(path = "/login")
public Map<String, String> login(@RequestBody UserTable userName) {
    List<UserTable> userNames = userService.findByEmailAndPassword(
        userName.getEmail(), userName.getPassword());
    
    Map<String, String> response = new HashMap<>();
    
    if (!userNames.isEmpty()) {
        UserTable usuarioRetorno = userNames.get(0);
        
        String role = usuarioRetorno.getUserRole().getName(); // Asume que `getRoleName()` devuelve "USER" o "ADMIN"
        response.put("status", "success");
        response.put("role", role);
        
    } else {
        response.put("status", "error");
        response.put("message", "Usuario o contraseña inválidos");
    }
    
    return response;
}


}
