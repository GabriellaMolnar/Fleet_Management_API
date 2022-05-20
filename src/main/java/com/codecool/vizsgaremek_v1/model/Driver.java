package com.codecool.vizsgaremek_v1.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Driver {
    @NotBlank
    @Pattern(regexp = "[0-9]")
    private long tribeNumber;
    @Pattern(regexp = "[^0-9]")
    private String name;
    private String birthDate;
    private String motherName;
}
