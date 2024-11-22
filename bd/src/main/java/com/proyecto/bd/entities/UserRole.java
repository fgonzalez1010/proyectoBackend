package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_ROLE")
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_ROLE_ROLEID_GENERATOR", sequenceName = "FMARROQUIN.SEQ_ROLE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_ROLEID_GENERATOR")
    @Column(name = "ROLE_ID")
    private long roleId;

    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "ROLE_OPTION",
        joinColumns = @JoinColumn(name = "ROLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "OPTION_ID")
    )
    private List<OptionTable> optionTables;

    @ManyToMany
    @JoinTable(
        name = "ROLE_PERMISSION",
        joinColumns = @JoinColumn(name = "ROLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")
    )
    private List<UserPermission> userPermissions;

    @JsonIgnore
    @OneToMany(mappedBy = "userRole")
    private List<UserTable> userTables;

     @JsonCreator
    public static UserRole fromId(@JsonProperty("roleId") long roleId) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        return userRole;
    }
}
