package com.codecool.vizsgaremek_v1.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepotAddDto {
    @NotBlank(message = "Depot name required")
    private String depotName;
    private String address;
}
