package com.proyecto.bd.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The primary key class for the SALE_PAYMENT_DETAIL database table.
 */
@Embeddable
@Data
@EqualsAndHashCode
public class SalePaymentDetailPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "SALE_ID", insertable = false, updatable = false)
    private long saleId;

    @Column(name = "PAYMENT_METHOD_ID", insertable = false, updatable = false)
    private long paymentMethodId;
}
