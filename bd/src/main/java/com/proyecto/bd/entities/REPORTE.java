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
@Table(name = "ROLE_NAME")
public class REPORTE implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String name;

}
