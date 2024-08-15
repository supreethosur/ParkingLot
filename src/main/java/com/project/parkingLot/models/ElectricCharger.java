package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ElectricCharger extends BaseModel{
    private int consumption;
}
