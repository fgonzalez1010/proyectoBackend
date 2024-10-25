package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PURCHASE_DETAIL")
@NamedQuery(name = "PurchaseDetail.findAll", query = "SELECT p FROM PurchaseDetail p")
public class PurchaseDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PURCHASE_DETAIL_PURCHASEDETAILID_GENERATOR",  sequenceName = "FGONZALEZPF.SEQ_PURCHASE_DETAIL_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_DETAIL_PURCHASEDETAILID_GENERATOR")
    @Column(name = "PURCHASE_DETAIL_ID")
    private long purchaseDetailId;

    private Integer quantity;

    @Column(name = "SUB_TOTAL")
    private BigDecimal subTotal;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "purchaseDetail")
    private List<InventoryMovement> inventoryMovements;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID")
    private Purchase purchase;
}
