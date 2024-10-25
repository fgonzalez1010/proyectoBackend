package com.proyecto.bd.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRANSACTION_AUDIT")
@NamedQuery(name = "TransactionAudit.findAll", query = "SELECT t FROM TransactionAudit t")
public class TransactionAudit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TRANSACTION_AUDIT_AUDITID_GENERATOR", sequenceName = "FGONZALEZPF.SEQ_AUDIT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_AUDIT_AUDITID_GENERATOR")
    @Column(name = "AUDIT_ID")
    private long auditId;

    @Temporal(TemporalType.DATE)
    @Column(name = "AUDIT_DATE")
    private Date auditDate;

    @Lob
    @Column(name = "CURRENT_VALUE")
    private String currentValue;

    private String event;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Lob
    @Column(name = "PREVIOUS_VALUE")
    private String previousValue;

    @Column(name = "TABLE_ID")
    private Integer tableId;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserTable userTable;
}
