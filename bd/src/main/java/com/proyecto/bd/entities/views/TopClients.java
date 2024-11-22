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
@Table(name = "V_TOP_CLIENTS")
public class TopClients implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CLIENT_ID")
    private long clientId;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "TOTAL_SPENT")
    private String totalSpent;



}
