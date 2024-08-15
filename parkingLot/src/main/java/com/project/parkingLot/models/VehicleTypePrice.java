package com.project.parkingLot.models;

import java.util.Map;

public class VehicleTypePrice extends BaseModel{
    private long basePrice;
    private Map<Integer, Long> multiplier;
}
