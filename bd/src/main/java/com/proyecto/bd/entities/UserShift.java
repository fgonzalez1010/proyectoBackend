package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_SHIFT")
@NamedQuery(name = "UserShift.findAll", query = "SELECT u FROM UserShift u")
public class UserShift implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserShiftPK id;

    @ManyToOne
    @JoinColumn(name = "SHIFT_ID")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserTable userTable;
}
