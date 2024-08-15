package com.project.parkingLot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot extends BaseModel{
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingFloor> parkingFloors;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Gate> gates;

//    private Map<VehicleType, VehicleTypePrice> vehicleTypePriceMap;
}
