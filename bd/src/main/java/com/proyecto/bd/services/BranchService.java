package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Branch;
import com.proyecto.bd.repository.BranchRepository;
@Service
public class BranchService {
    
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public Optional<Branch> getBranchById(Long id) {
        return branchRepository.findById(id);
    }

    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }


    public Branch updateBranch(Long id, Branch updatedBrand) {
        return branchRepository.findById(id)
                .map(existingBrand -> {
                    existingBrand.setName(updatedBrand.getName());
                    existingBrand.setAddress(updatedBrand.getAddress());
                    existingBrand.setEmail(updatedBrand.getEmail());
                    existingBrand.setPhone(updatedBrand.getPhone());
                    existingBrand.setActive(updatedBrand.getActive());
                    return branchRepository.save(existingBrand);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteBranch(Long id) {
        if (branchRepository.existsById(id)) {
            branchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }
}


