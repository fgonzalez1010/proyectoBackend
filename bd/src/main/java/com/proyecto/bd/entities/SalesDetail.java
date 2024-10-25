package com.proyecto.bd.entities;

import java.io.Serializable;
import java.util.List;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SALES_DETAIL")
@NamedQuery(name = "SalesDetail.findAll", query = "SELECT s FROM SalesDetail s")
public class SalesDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SALES_DETAIL_SALEDETAILID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_SALE_DETAIL_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_DETAIL_SALEDETAILID_GENERATOR")
    @Column(name = "SALE_DETAIL_ID")
    private long saleDetailId;

    private Integer quantity;

    @Column(name = "SUB_TOTAL")
    private Integer subTotal;

    @Column(name = "UNIT_PRICE")
    private Integer unitPrice;

    @OneToMany(mappedBy = "salesDetail")
    private List<InventoryMovement> inventoryMovements;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "SALE_ID")
    private Sale sale;
}
