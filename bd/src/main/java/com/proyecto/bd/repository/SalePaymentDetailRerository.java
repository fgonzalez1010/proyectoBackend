package com.proyecto.bd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.bd.entities.SalePaymentDetail;
import com.proyecto.bd.entities.SalePaymentDetailPK;

public interface SalePaymentDetailRerository extends CrudRepository<SalePaymentDetail, SalePaymentDetailPK> {
    List<SalePaymentDetail> findAll();

}
