package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Payment extends BaseModel{
    private String transactionNumber;
    private double amount;
    private Date timeOfPayment;
    @OneToOne
    private Invoice invoice;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
}
