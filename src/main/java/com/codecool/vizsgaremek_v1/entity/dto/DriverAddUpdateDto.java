package com.codecool.vizsgaremek_v1.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class DriverAddUpdateDto {

    @NotNull
    @Range(min=10000, max=999999)
    private long tribeNumber;
    @Length(min = 5, max = 50)
    private String name;
    @Past(message = "birthady must be in the past")
    private LocalDate birthDate;
    @Length(min = 5, max = 50)
    private String motherName;
}
