package com.codecool.vizsgaremek_v1.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Car {
    private int id;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private Brand brand;
    private String model;
    private String color;
    private String engineNumber;
    boolean passengerCar;
}
