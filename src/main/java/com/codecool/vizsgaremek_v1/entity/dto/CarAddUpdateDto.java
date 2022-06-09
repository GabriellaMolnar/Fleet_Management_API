package com.codecool.vizsgaremek_v1.entity.dto;

import com.codecool.vizsgaremek_v1.entity.Brand;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CarAddUpdateDto {
    @NotBlank(message = "registration number required")
    private String registrationNumber;
    @NotNull(message = "brand required")
    private Brand brand;
    private String model;
    private String color;
    private String engineNumber;
    boolean passengerCar;
}
