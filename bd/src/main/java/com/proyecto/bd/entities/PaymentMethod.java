package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_METHOD")
@NamedQuery(name = "PaymentMethod.findAll", query = "SELECT p FROM PaymentMethod p")
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PAYMENT_METHOD_PAYMENTMETHODID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_PAYMENT_METHOD_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_METHOD_PAYMENTMETHODID_GENERATOR")
    @Column(name = "PAYMENT_METHOD_ID")
    private long paymentMethodId;

    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Sale> sales;

    @OneToMany(mappedBy = "paymentMethod")
    private List<SalePaymentDetail> salePaymentDetails;
}
