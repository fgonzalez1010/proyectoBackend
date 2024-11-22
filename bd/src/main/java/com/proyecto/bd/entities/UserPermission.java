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
@Table(name = "USER_PERMISSION")
@NamedQuery(name = "UserPermission.findAll", query = "SELECT u FROM UserPermission u")
public class UserPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_PERMISSION_PERMISSIONID_GENERATOR",sequenceName = "FMARROQUIN.SEQ_PERMISSION_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PERMISSION_PERMISSIONID_GENERATOR")
    @Column(name = "PERMISSION_ID")
    private long permissionId;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "userPermissions")
    private List<UserRole> userRoles;
}
