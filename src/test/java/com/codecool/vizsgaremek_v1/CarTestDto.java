package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Brand;
import lombok.Data;


@Data
public class CarTestDto {
    private long id;
    private String registrationNumber;
    private Brand brand;
    private String model;
    private String color;
    private String engineNumber;
    boolean passengerCar;
    private String driver;
    private String depot;
    private int carValue;
}
