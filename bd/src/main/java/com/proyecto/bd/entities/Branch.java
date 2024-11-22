package com.proyecto.bd.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_BRANCHID_GENERATOR")
    @SequenceGenerator(name = "BRANCH_BRANCHID_GENERATOR", sequenceName = "FMARROQUIN.SEQ_BRANCH_ID", allocationSize = 1)
    @Column(name = "BRANCH_ID")
    private long branchId;

    private String active;
    private String address;
    private String email;
    private String name;
    private String phone;

    /* 
    @OneToMany(mappedBy = "branch")
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "branch")
    private List<InventoryMovement> inventoryMovements;

    @OneToMany(mappedBy = "branch")
    private List<Sale> sales;

    @OneToMany(mappedBy = "branch")
    private List<UserTable> userTables;
    */
 @JsonCreator
    public static Branch fromId(@JsonProperty("branchId") long branchId) {
        Branch branch = new Branch();
        branch.setBranchId(branchId);
        return branch;
    }
    
}
