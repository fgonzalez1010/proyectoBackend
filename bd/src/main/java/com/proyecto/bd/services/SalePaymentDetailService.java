package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.SalePaymentDetail;
import com.proyecto.bd.entities.SalePaymentDetailPK;
import com.proyecto.bd.repository.SalePaymentDetailRerository;

@Service
public class SalePaymentDetailService {
    
    private final SalePaymentDetailRerository salePaymentRepository;

    public SalePaymentDetailService(SalePaymentDetailRerository salePaymentRepository) {
        this.salePaymentRepository = salePaymentRepository;
    }

    public List<SalePaymentDetail> getAllSalePaymentDetail() {
        return salePaymentRepository.findAll();
    }

    public Optional<SalePaymentDetail> getSalePaymentDetailById(SalePaymentDetailPK id) {
        return salePaymentRepository.findById(id);
    }
}
