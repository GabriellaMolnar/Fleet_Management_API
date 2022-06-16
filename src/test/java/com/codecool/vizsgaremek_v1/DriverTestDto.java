package com.codecool.vizsgaremek_v1;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class DriverTestDto {
    private long tribeNumber;
    private String name;
    private LocalDate birthDate;
    private String motherName;
    private List<String> cars = new ArrayList<>();
}
