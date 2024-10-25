package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.UserShift;
import com.proyecto.bd.entities.UserShiftPK;

public interface UserShiftRepository extends CrudRepository<UserShift, UserShiftPK>{

    List<UserShift> findAll();
}
