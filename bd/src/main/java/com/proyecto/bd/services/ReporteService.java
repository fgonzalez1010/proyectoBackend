package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.REPORTE;
import com.proyecto.bd.entities.UserRole;
import com.proyecto.bd.repository.REPORTEREPOSITORY;
import com.proyecto.bd.repository.RolesRepository;

@Service
public class ReporteService {

    
    private final REPORTEREPOSITORY roleRepository;

    public ReporteService(REPORTEREPOSITORY roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<REPORTE> getAllRole() {
        return roleRepository.findAll();
    }
}
