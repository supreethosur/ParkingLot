package com.project.parkingLot.controllers;

import com.project.parkingLot.dtos.CreateParkingLotRequestDto;
import com.project.parkingLot.dtos.CreateParkingLotResponseDto;
import com.project.parkingLot.dtos.ResponseDto;
import com.project.parkingLot.models.ParkingLot;
import com.project.parkingLot.services.ParkingLotService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingLotController {
    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/addParkingLot")
    public CreateParkingLotResponseDto createParkingLot(@RequestBody CreateParkingLotRequestDto request) {
//        String address = "Hyderabad Telangana";
//        List<Integer> floors = Arrays.asList(-1,-2);
//        List<List<List<Integer>>> allocation = Arrays.asList(Arrays.asList(Arrays.asList(0,30, 10), Arrays.asList(31,40,20), Arrays.asList(-1, -1,-1), Arrays.asList(41, 49, 100)),
//                Arrays.asList(Arrays.asList(-1,-1,-1), Arrays.asList(0,49,50), Arrays.asList(-1, -1,-1), Arrays.asList(-1, -1,-1)));
//
//        List<List<Integer>> gates = Arrays.asList(Arrays.asList(1, 1, 2, 1), Arrays.asList(2,2,1,1));
        String address = request.getAddress();
        List<Integer> floors = request.getFloors();
        List<List<List<Integer>>> allocation = request.getAllocation();
        List<List<Integer>> gates = request.getGates();

        ParkingLot parkingLot = parkingLotService.createParkingLot(address, floors, allocation, gates);


        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        return response;
    }

    @DeleteMapping("/deleteParkingLot/{parkingLotId}")
    public void deleteParkingLot(@PathVariable Long parkingLotId){
        parkingLotService.deleteParkingLot(parkingLotId);

    }

}

/*
ParkingLot:
    private String address;
    @OneToMany
    private List<ParkingFloor> parkingFloors;
    @OneToMany
    private List<Gate> gates;

ParkingFloor:
    @OneToMany
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private Status status;

ParkingSpot
    private int spotNumber;
    @ManyToOne
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    int spotPrice;
 */