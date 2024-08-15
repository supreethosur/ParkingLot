package com.project.parkingLot.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateParkingLotRequestDto {
    private String address;
    List<Integer> floors;
    List<List<List<Integer>>> allocation;
    List<List<Integer>> gates;
}
