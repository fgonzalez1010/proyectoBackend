package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.PurchaseDetail;
import com.proyecto.bd.repository.PurchaseDetailRepository;

@Service
public class PurchaseDetailService {

    
    private final PurchaseDetailRepository PurchaseDetailRepository;

    public PurchaseDetailService(PurchaseDetailRepository PurchaseDetailRepository) {
        this.PurchaseDetailRepository = PurchaseDetailRepository;
    }

    public List<PurchaseDetail> getAllPurchaseD() {
        return PurchaseDetailRepository.findAll();
    }

    public Optional<PurchaseDetail> getPurchaseDById(Long id) {
        return PurchaseDetailRepository.findById(id);
    }

    public PurchaseDetail createPurchaseD(PurchaseDetail brand) {
        return PurchaseDetailRepository.save(brand);
    }

    public PurchaseDetail updatePurchaseD(Long id, PurchaseDetail updatedPd) {
        return PurchaseDetailRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setQuantity(updatedPd.getQuantity());
                    existingBrand.setUnitPrice(updatedPd.getUnitPrice());
                    existingBrand.setSubTotal(updatedPd.getSubTotal());
                    return PurchaseDetailRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

}
