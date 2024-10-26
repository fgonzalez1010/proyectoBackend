package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.SalesDetail;
import com.proyecto.bd.repository.SaleDetailRepository;

@Service
public class SaleDetailService {

     private final SaleDetailRepository saleDRepository;

    public SaleDetailService(SaleDetailRepository saleDRepository) {
        this.saleDRepository = saleDRepository;
    }

    public List<SalesDetail> getAllSalesDetail() {
        return saleDRepository.findAll();
    }

    public Optional<SalesDetail> getSalesDetailById(Long id) {
        return saleDRepository.findById(id);
    }

    public SalesDetail createSalesDetail(SalesDetail brand) {
        return saleDRepository.save(brand);
    }

    public SalesDetail updateSalesDetail(Long id, SalesDetail updatedBrand) {
        return saleDRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setQuantity(updatedBrand.getQuantity());
                    existingBrand.setUnitPrice(updatedBrand.getUnitPrice());
                    existingBrand.setSubTotal(updatedBrand.getSubTotal());
                    return saleDRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }
}
