package com.codecool.vizsgaremek_v1.entity.dto;

import com.codecool.vizsgaremek_v1.entity.Brand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarAddUpdateDto {

    private String registrationNumber;
    private Brand brand;
    private String model;
    private String color;
    private String engineNumber;
    boolean passengerCar;
}
