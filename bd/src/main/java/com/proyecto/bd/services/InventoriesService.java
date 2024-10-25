package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Inventory;
import com.proyecto.bd.repository.InventoriesRepository;

@Service
public class InventoriesService {

    private final InventoriesRepository inventoryRepository;

    public InventoriesService(InventoriesRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory createInventory(Inventory brand) {
        return inventoryRepository.save(brand);
    }

    public Inventory updateInventory(Long id, Inventory updatedBrand) {
        return inventoryRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setStock(updatedBrand.getStock());
                    return inventoryRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteInventory(Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }

}
