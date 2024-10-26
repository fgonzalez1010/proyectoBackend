package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.UserTable;
import com.proyecto.bd.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserTable> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserTable> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserTable createUser(UserTable brand) {
        return userRepository.save(brand);
    }

    public UserTable updateUser(Long id, UserTable updatedBrand) {
        return userRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setUserRole(updatedBrand.getUserRole());
                    existingBrand.setBranch(updatedBrand.getBranch());
                    existingBrand.setUsername(updatedBrand.getUsername());
                    existingBrand.setEmail(updatedBrand.getEmail());
                    existingBrand.setPassword(updatedBrand.getPassword());
                    existingBrand.setActive(updatedBrand.getActive());
                    return userRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }

    public List<UserTable> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
    
}
