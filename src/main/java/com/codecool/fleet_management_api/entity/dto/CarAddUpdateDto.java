package com.codecool.fleet_management_api.entity.dto;

import com.codecool.fleet_management_api.entity.Brand;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "registration number", example = "RON-963")
    @NotBlank(message = "registration number required")
    @Pattern(regexp = "^[A-Z]{3}-[0-9]{3}$")
    private String registrationNumber;

    @Schema(description = "brand", example = "NISSAN")
    @NotNull(message = "brand required")
    private Brand brand;

    @Schema(description = "model", example = "LEAF")
    @Length(min = 2, max = 30, message = "Model must be between 2 and 30 characters")
    private String model;

    @Schema(description = "color", example = "magenta")
    @Length(min = 2, max = 30, message = "Color must be between 2 and 30 characters")
    private String color;

    @Schema(description = "engine number", example = "2FMGK5CC2BBD13552")
    @Length(min = 10, max = 20, message = "Engine number must be between 10 and 20 characters")
    private String engineNumber;
    @NotNull
    boolean passengerCar;
}
