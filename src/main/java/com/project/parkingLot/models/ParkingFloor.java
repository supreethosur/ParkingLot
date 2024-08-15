package com.project.parkingLot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloor extends BaseModel{
    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private Status status;
}
