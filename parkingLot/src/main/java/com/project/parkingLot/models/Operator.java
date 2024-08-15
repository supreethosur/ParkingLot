package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Operator extends BaseModel{
    private String name;
    private String phoneNo;
    private String emailId;
}
