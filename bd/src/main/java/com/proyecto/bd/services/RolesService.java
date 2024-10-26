package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.UserRole;
import com.proyecto.bd.repository.RolesRepository;

@Service
public class RolesService {

    
    private final RolesRepository roleRepository;

    public RolesService(RolesRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<UserRole> getAllRole() {
        return roleRepository.findAll();
    }

    public Optional<UserRole> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public UserRole createRole(UserRole brand) {
        return roleRepository.save(brand);
    }

    public void deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }

}
