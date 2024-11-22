package com.proyecto.bd.entities.views;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "V_LOW_PRODUCTS")
public class LowProducts implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUCT_ID")
    private long producId;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "LINE_NAME")
    private String lineName;

    @Column(name = "BRAND_NAME")
    private String brandName;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "TOTAL_SALE")
    private String totalSale;



}
