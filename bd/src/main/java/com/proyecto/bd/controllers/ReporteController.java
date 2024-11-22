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

import com.proyecto.bd.entities.REPORTE;
import com.proyecto.bd.entities.UserRole;
import com.proyecto.bd.services.ReporteService;
import com.proyecto.bd.services.RolesService;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:4200")
public class ReporteController {

    
    @Autowired
    private ReporteService rolesService;

    // Obtener todas las marcas
    @GetMapping
    public List<REPORTE> getAllInventories() {
        return rolesService.getAllRole();
    }

}
