package com.project.parkingLot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Invoice extends BaseModel{
    @OneToOne
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    @OneToOne
    private Operator operator;
    @Enumerated(EnumType.ORDINAL)
    private InvoicePaidStatus invoicePaidStatus;
    @OneToMany
    private List<Payment> payments;
}
