package com.codecool.vizsgaremek_v1.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DriverAddUpdateDto {

    private long tribeNumber;
    private String name;
    private LocalDate birthDate;
    private String motherName;
}
