package com.proyecto.bd.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_BRANDID_GENERATOR")
    @SequenceGenerator(name = "BRAND_BRANDID_GENERATOR", sequenceName = "FMARROQUIN.SEQ_BRAND_ID", allocationSize = 1)
    @Column(name = "BRAND_ID")
    private long brandId;

    private String name;
}
