package com.codecool.fleet_management_api.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class CarValueAddUpdateDto {
    @NotNull
    private long carId;
    @PastOrPresent(message = "entry date must be in the past")
    private LocalDate entryDate;
    @Range(min = 0, max = 100000000)
    private int grossValue;
    @NotNull
    private LocalDate plannedEndOfLife;
    @Range(min = 0, max = 20000000)
    private int priceEndOfLife;
}
