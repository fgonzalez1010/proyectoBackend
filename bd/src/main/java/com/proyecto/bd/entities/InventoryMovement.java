package com.proyecto.bd.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVENTORY_MOVEMENT")
@NamedQuery(name = "InventoryMovement.findAll", query = "SELECT i FROM InventoryMovement i")
public class InventoryMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "INVENTORY_MOVEMENT_MOVEMENTID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_MOVEMENT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_MOVEMENT_MOVEMENTID_GENERATOR")
    @Column(name = "MOVEMENT_ID")
    private long movementId;

    @Temporal(TemporalType.DATE)
    @Column(name = "MOVEMENT_DATE")
    private Date movementDate;

    @Column(name = "MOVEMENT_TYPE")
    private String movementType;

    private Integer quantity;

    @Column(name = "USER_ID")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_DETAIL_ID")
    private PurchaseDetail purchaseDetail;

    @ManyToOne
    @JoinColumn(name = "SALE_DETAIL_ID")
    private SalesDetail salesDetail;
}
