package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShiftPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID", insertable = false, updatable = false)
    private long userId;

    @Column(name = "SHIFT_ID", insertable = false, updatable = false)
    private long shiftId;

    @Temporal(TemporalType.DATE)
    @Column(name = "SHIFT_DATE")
    private Date shiftDate;
}
