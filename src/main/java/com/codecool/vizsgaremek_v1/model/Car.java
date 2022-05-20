package com.codecool.vizsgaremek_v1.model;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String registrationNumber;
    private Brand brand;
    private String model;
    private String color;
    private String engineNumber;
    boolean passengerCar;
}
