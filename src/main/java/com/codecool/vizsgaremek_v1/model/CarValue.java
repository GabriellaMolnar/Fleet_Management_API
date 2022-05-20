package com.codecool.vizsgaremek_v1.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarValue {
    private int carId;
    private LocalDate entryDate;
    private int grossValue;
    private int netValue;
    private LocalDate plannedEndOfLife;
    private int priceEndOfLife;
}
