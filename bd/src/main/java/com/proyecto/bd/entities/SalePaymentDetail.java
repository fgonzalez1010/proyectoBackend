package com.proyecto.bd.entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SALE_PAYMENT_DETAIL")
@NamedQuery(name = "SalePaymentDetail.findAll", query = "SELECT s FROM SalePaymentDetail s")
public class SalePaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SalePaymentDetailPK id;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_METHOD_ID")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "SALE_ID")
    private Sale sale;
}
