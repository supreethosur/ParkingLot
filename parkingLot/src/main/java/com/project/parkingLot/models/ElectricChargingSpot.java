package com.project.parkingLot.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
public class ElectricChargingSpot extends BaseModel{
    @OneToOne
    private ParkingSpot parkingSpot;
}
