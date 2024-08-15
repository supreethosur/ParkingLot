package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Gate extends BaseModel{
    private int number;
    @Enumerated(EnumType.ORDINAL)
    private GateType gateType;
    @OneToOne
    private Operator operator;
    @Enumerated(EnumType.ORDINAL)
    private GateStatus gateStatus;
}
