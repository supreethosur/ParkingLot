package com.project.parkingLot.services;


import com.project.parkingLot.models.*;
import com.project.parkingLot.repositories.OperatorRepository;
import com.project.parkingLot.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private OperatorRepository operatorRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository, OperatorRepository operatorRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.operatorRepository = operatorRepository;
    }

    public ParkingLot createParkingLot(String address, List<Integer> floors, List<List<List<Integer>>> allocation, List<List<Integer>> gates) {

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        List<Gate> parkingLotGates = new ArrayList<>();
        for(int i=0; i<floors.size(); i++){
            List<List<Integer>> floor = allocation.get(i);
            int floorNo = floors.get(i);

            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for(int j=0; j<4; j++){
                VehicleType vehicleTypeEnum = null;
                List<Integer> spotsDetails = floor.get(j);
                if(j==0){
                    vehicleTypeEnum = VehicleType.TWO_W;
                }
                else if(j==1){
                    vehicleTypeEnum = VehicleType.FOUR_W;
                }
                else if(j==2){
                    vehicleTypeEnum = VehicleType.TWO_WE;
                }
                else if(j==3){
                    vehicleTypeEnum = VehicleType.FOUR_WE;
                }
                ParkingSpotStatus status = ParkingSpotStatus.AVAILABLE;

                if(spotsDetails.get(0)==-1 || spotsDetails.get(1)==-1){
                    continue;
                }
                for(int spotNo = spotsDetails.get(0); spotNo<=spotsDetails.get(1); spotNo++){
                    parkingSpots.add(new ParkingSpot(spotNo, vehicleTypeEnum, status, spotsDetails.get(2)));
                }

            }

            Status floorStatus = Status.RUNNING;
            ParkingFloor parkingFloor = new ParkingFloor(parkingSpots, floorNo, floorStatus);

            parkingFloors.add(parkingFloor);

        }

        for(int gate=0; gate<gates.size(); gate++){
            int gateNumber = gates.get(gate).get(0);
            int gateType = gates.get(gate).get(1);
            int operatorId = gates.get(gate).get(2);
            int gateStatus = gates.get(gate).get(3);

            GateType gateTypeEnum = null;
            if(gateType==1){
                gateTypeEnum = GateType.ENTRY;
            }
            else if(gateType==2){
                gateTypeEnum = GateType.EXIT;
            }

            Optional<Operator> optionalOperator = operatorRepository.findById((long)operatorId);
            Operator operator = null;
            if(optionalOperator.isPresent()){
                operator = optionalOperator.get();
            }

            GateStatus gateStatusEnum = null;
            if(gateStatus == 1){
                gateStatusEnum = GateStatus.OPEN;
            }
            else if(gateStatus == 2){
                gateStatusEnum = GateStatus.CLOSED;
            }

            parkingLotGates.add(new Gate(gateNumber, gateTypeEnum, operator, gateStatusEnum));
        }

        ParkingLot parkingLot = new ParkingLot(address, parkingFloors, parkingLotGates);
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);

        System.out.println("save the parking lot");
        System.out.println("id= "+savedParkingLot.getId());

        return savedParkingLot;
    }

    public void deleteParkingLot(long parkingLotId){
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
        ParkingLot parkingLot = null;
        if(parkingLotOptional.isPresent()){
            parkingLot = parkingLotOptional.get();
        }
        parkingLotRepository.delete(parkingLot);
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

Gate:
private int number;
    @Enumerated(EnumType.ORDINAL)
    private GateType gateType;
    @OneToOne
    private Operator operator;
    @Enumerated(EnumType.ORDINAL)
    private GateStatus gateStatus;
 */
