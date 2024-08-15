package com.project.parkingLot.strategies.spotassignmentstrategy;


import com.project.parkingLot.models.Gate;
import com.project.parkingLot.models.ParkingLot;
import com.project.parkingLot.models.ParkingSpot;
import com.project.parkingLot.models.SpotType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot,
                           SpotType spotType,
                           Gate entryGate);
}
