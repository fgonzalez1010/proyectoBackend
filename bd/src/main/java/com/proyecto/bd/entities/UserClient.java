package com.proyecto.bd.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "USER_CLIENT")
@NamedQuery(name = "UserClient.findAll", query = "SELECT u FROM UserClient u")
public class UserClient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_CLIENT_CLIENTID_GENERATOR",sequenceName = "FGONZALEZPF.SEQ_CLIENT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_CLIENT_CLIENTID_GENERATOR")
    @Column(name = "CLIENT_ID")
    private long clientId;

    private String address;

    @Column(name = "CLIENT_CODE")
    private Integer clientCode;

    private String email;
    private String name;
    private String nit;
    private String password;

    @Column(name = "REGISTER")
    private Character register;

    @JsonIgnore
    @OneToMany(mappedBy = "userClient")
    private List<Sale> sales;
}
