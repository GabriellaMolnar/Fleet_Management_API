package com.codecool.vizsgaremek_v1.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class CarValueAddUpdateDto {
    @NotNull
    private long carId;
    @Past(message = "entry date must be in the past")
    private LocalDate entryDate;
    @Range(min=0, max=100000000)
    private int grossValue;
    private LocalDate plannedEndOfLife;
    @Range(min=0, max=20000000)
    private int priceEndOfLife;
}
