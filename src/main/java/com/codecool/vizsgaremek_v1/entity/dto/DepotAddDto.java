package com.codecool.vizsgaremek_v1.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class DepotAddDto {
    @NotBlank(message = "Depot name required")
    private String depotName;
    @Length(min = 2, max = 100, message = "Address must be between 2 and 100 characters")
    private String address;
}
