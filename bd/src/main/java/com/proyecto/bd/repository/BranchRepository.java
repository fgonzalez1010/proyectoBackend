package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.Branch;

public interface BranchRepository extends CrudRepository<Branch, Long> {
    List<Branch> findAll();
}
