package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Sale;
import com.proyecto.bd.repository.SaleRepository;

@Service
public class SaleService {

    
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSale() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale brand) {
        return saleRepository.save(brand);
    }

    public Sale updateSale(Long id, Sale updatedBrand) {
        return saleRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setTotal(updatedBrand.getTotal());
                    existingBrand.setSaleDate(updatedBrand.getSaleDate());
                    existingBrand.setMailingAddress(updatedBrand.getMailingAddress());
                    existingBrand.setInvoiceNumber(updatedBrand.getInvoiceNumber());
                    existingBrand.setInvoiceSeries(updatedBrand.getInvoiceSeries());
                    existingBrand.setStatus(updatedBrand.getStatus());
                    existingBrand.setSaleNumber(updatedBrand.getSaleNumber());
                    return saleRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteSale(Long id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }

}
