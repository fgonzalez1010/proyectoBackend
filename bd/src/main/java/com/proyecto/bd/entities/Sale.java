package com.proyecto.bd.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SALE_SALEID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_SALE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SALEID_GENERATOR")
    @Column(name = "SALE_ID")
    private long saleId;

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name = "INVOICE_SERIES")
    private String invoiceSeries;

    @Column(name = "MAILING_ADDRESS")
    private String mailingAddress;

    @Temporal(TemporalType.DATE)
    @Column(name = "SALE_DATE")
    private Date saleDate;

    @Column(name = "SALE_NUMBER")
    private Integer saleNumber;

    private String status;
    private Integer total;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PAYMENT_METHOD_ID")
    private PaymentMethod paymentMethod;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private UserClient userClient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserTable userTable;
    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<SalesDetail> salesDetails;
    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<SalePaymentDetail> salePaymentDetails;
}
