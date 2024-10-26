package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR",  sequenceName = "FGONZALEZPF.SEQ_PRODUCT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
    @Column(name = "PRODUCT_ID")
    private long productId;

    private String active;
    private String name;
    private BigDecimal price;
    private String sku;

    @Lob
    private String specs;

    @Column(name = "URL_IMAGE")
    private String urlImage;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Inventory> inventories;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "LINE_ID")
    private ProductLine productLine;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<PurchaseDetail> purchaseDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SalesDetail> salesDetails;
}
