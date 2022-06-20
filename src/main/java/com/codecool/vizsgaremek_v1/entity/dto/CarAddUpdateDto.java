package com.codecool.vizsgaremek_v1.entity.dto;

import com.codecool.vizsgaremek_v1.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarAddUpdateDto {
    @NotBlank(message = "registration number required")
    @Pattern(regexp = "^[A-Z]{3}-[0-9]{3}$")
    private String registrationNumber;
    @NotNull(message = "brand required")
    private Brand brand;
    @Length(min = 2, max = 30, message = "Model must be between 2 and 30 characters")
    private String model;
    @Length(min = 2, max = 30, message = "Color must be between 2 and 30 characters")
    private String color;
    @Length(min = 10, max = 40, message = "Engine number must be between 10 and 40 characters")
    private String engineNumber;
    @NotNull
    boolean passengerCar;
}
