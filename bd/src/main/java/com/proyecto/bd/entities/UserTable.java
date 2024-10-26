package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
@NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u")
public class UserTable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_TABLE_USERID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_USER_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_TABLE_USERID_GENERATOR")
    @Column(name = "USER_ID")
    private long userId;

    private String active;
    private String email;

    @Column(name = "LAST_NAME")
    private String lastName;

    private String name;
    private String password;
    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "userTable")
    private List<Purchase> purchases;

    @JsonIgnore
    @OneToMany(mappedBy = "userTable")
    private List<Sale> sales;


    @OneToMany(mappedBy = "userTable")
    private List<UserShift> userShifts;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private UserRole userRole;
}
