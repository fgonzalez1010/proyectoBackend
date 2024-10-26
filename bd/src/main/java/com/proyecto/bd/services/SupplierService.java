package com.proyecto.bd.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.proyecto.bd.entities.Supplier;
import com.proyecto.bd.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }


    
     public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

     public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    existingSupplier.setName(updatedSupplier.getName());
                    return supplierRepository.save(existingSupplier);
                }).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    public void deleteSupplier(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        } else {
            throw new RuntimeException("supplier not found with id: " + id);
        }
    }





}
