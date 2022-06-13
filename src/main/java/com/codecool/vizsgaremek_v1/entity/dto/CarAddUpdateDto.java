package com.codecool.vizsgaremek_v1.entity.dto;

import com.codecool.vizsgaremek_v1.entity.Brand;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CarAddUpdateDto {
    @NotBlank(message = "registration number required")
    private String registrationNumber;
    @NotNull(message = "brand required")
    private Brand brand;
    @Length(min = 2, max = 30)
    private String model;
    private String color;
    @Length(min = 10, max = 40)
    private String engineNumber;
    boolean passengerCar;
}
