package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p")
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PURCHASE_PURCHASEID_GENERATOR",  sequenceName = "FGONZALEZPF.SEQ_PURCHASE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_PURCHASEID_GENERATOR")
    @Column(name = "PURCHASE_ID")
    private long purchaseId;

    @Temporal(TemporalType.DATE)
    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;

    @Column(name = "PURCHASE_NUMBER")
    private Integer purchaseNumber;

    private String status;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_METHOD_ID")
    private PaymentMethod paymentMethod;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserTable userTable;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> purchaseDetails;
}
