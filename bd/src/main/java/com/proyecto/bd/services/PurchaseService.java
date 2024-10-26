package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Purchase;
import com.proyecto.bd.repository.PurchaseRepository;

@Service
public class PurchaseService {

    
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchasedById(Long id) {
        return purchaseRepository.findById(id);
    }

    public Purchase createPurchase(Purchase brand) {
        return purchaseRepository.save(brand);
    }

    public Purchase updatePurchase(Long id, Purchase updatedBrand) {
        return purchaseRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setPurchaseDate(updatedBrand.getPurchaseDate());
                    existingBrand.setPurchaseNumber(updatedBrand.getPurchaseNumber());
                    existingBrand.setStatus(updatedBrand.getStatus());
                    existingBrand.setTotal(updatedBrand.getTotal());
                    return purchaseRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deletePurchase(Long id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }
}
