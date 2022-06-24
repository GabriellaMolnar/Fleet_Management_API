package com.codecool.fleet_management_api;

import com.codecool.fleet_management_api.entity.Brand;
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
