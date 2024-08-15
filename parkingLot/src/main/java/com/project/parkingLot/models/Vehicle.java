package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Vehicle extends BaseModel{
    private  String number;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
}
