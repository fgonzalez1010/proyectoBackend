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
@NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SUPPLIER_SUPPLIERID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_SUPPLIER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_SUPPLIERID_GENERATOR")
    @Column(name = "SUPPLIER_ID")
    private long supplierId;

    private String address;
    private String email;
    private String name;
    private String nit;
    private String phone;

    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchases;
}
