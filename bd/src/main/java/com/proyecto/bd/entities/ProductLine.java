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
@Table(name = "PRODUCT_LINE")
@NamedQuery(name = "ProductLine.findAll", query = "SELECT p FROM ProductLine p")
public class ProductLine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PRODUCT_LINE_LINEID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_LINE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_LINE_LINEID_GENERATOR")
    @Column(name = "LINE_ID")
    private long lineId;

    private String name;

    @OneToMany(mappedBy = "productLine")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private Brand brand;
}
