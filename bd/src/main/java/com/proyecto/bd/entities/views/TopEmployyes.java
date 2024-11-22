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
@Table(name = "V_TOP_EMPLOYYES")
public class TopEmployyes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "EMPLOYEE")
    private String employye;

    @Column(name = "TOTAL_CLIENTS_ATTENDED")
    private String clientAttended;




}
