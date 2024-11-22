package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OPTION_TABLE")
@NamedQuery(name = "OptionTable.findAll", query = "SELECT o FROM OptionTable o")
public class OptionTable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "OPTION_TABLE_OPTIONID_GENERATOR", sequenceName = "FMARROQUIN.SEQ_OPTION_ID", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPTION_TABLE_OPTIONID_GENERATOR")
    @Column(name = "OPTION_ID")
    private long optionId;

    private String active;
    private String icon;
    private String name;

    @Column(name = "ORDER_NUMBER")
    private BigDecimal orderNumber;

    private String route;

    @ManyToMany(mappedBy = "optionTables")
    private List<UserRole> userRoles;
}
