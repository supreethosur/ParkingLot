package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Ticket extends BaseModel{
    private Date entryTime;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private ParkingSpot parkingSpot;
    @ManyToOne
    private Operator generatedBy;
    @ManyToOne
    private ParkingLot parkingLot;
    @OneToOne
    private Gate entryGate;
    private String ownerName;
}
