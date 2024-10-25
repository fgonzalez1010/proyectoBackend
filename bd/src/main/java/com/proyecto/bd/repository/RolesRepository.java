package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.UserRole;

public interface RolesRepository extends CrudRepository<UserRole, Long>{
 List<UserRole> findAll();
}
