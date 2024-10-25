package com.proyecto.bd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s")
public class Shift implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SHIFT_SHIFTID_GENERATOR",sequenceName = "FGONZALEZPF.SEQ_SHIFT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIFT_SHIFTID_GENERATOR")
    @Column(name = "SHIFT_ID")
    private long shiftId;

    @Column(name = "END_TIME")
    private String endTime;

    private String name;

    @Column(name = "START_TIME")
    private String startTime;

    @OneToMany(mappedBy = "shift")
    private List<UserShift> userShifts;
}
