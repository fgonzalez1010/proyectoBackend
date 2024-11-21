package com.proyecto.bd.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public List<UserTable> findByEmailAndPassword(String email, String password) {
        // Encriptar la contraseña usando el método encryptPassword
        String encryptedPassword = encryptPassword(password);

        // Buscar el usuario con el email y la contraseña encriptada
        return userRepository.findByEmailAndPassword(email, encryptedPassword);
    }

    public static String encryptPassword(String password) {
        try {
            // Crear un objeto MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Aplicar el hash sobre la contraseña
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convertir el hash a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b); // Convierte el byte a formato hexadecimal
                if (hex.length() == 1) {
                    hexString.append('0'); // Asegura que todos los bytes tengan dos caracteres hexadecimales
                }
                hexString.append(hex);
            }

            // Devolver el hash en formato hexadecimal
            return hexString.toString().toUpperCase(); // Asegurarse de que esté en mayúsculas
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No existe el algoritmo de encriptación SHA-256", e);
        }
    }

}
