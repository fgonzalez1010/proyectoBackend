package com.proyecto.bd.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "LINE_ID")
    private ProductLine productLine;


}
