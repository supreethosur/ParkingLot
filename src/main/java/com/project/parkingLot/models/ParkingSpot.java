package com.project.parkingLot.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot extends BaseModel{
    private int spotNumber;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
    @Enumerated(EnumType.ORDINAL)
    private ParkingSpotStatus parkingSpotStatus;
    int spotPrice;
}
