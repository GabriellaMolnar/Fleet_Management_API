package com.codecool.vizsgaremek_v1;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CarValueTestDto {
    private long carId;
    private LocalDate entryDate;
    private int grossValue;
    private LocalDate plannedEndOfLife;
    private int priceEndOfLife;
    private int netValue;
    private int monthlyDepr;
    private String car;
}
