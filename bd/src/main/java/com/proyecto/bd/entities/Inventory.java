package com.proyecto.bd.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_INVENTORYID_GENERATOR")
    @SequenceGenerator(name = "INVENTORY_INVENTORYID_GENERATOR",sequenceName = "FGONZALEZPF.SEQ_INVENTORY_ID", allocationSize = 1 )
    @Column(name = "INVENTORY_ID")
    private long inventoryId;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
