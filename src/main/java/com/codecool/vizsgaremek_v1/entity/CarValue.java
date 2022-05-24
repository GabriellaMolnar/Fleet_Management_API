package com.codecool.vizsgaremek_v1.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
public class CarValue {
    @Id
    @NotBlank
    @Column(name = "car_id")
    private long carId;
    @Column(name = "entry_date")
    private LocalDate entryDate;

    private int grossValue;

 //   private int netValue; -- calculated??

    private LocalDate plannedEndOfLife;

    @Length(max = 7)
    @Pattern(regexp = "[0-9]")
    private int priceEndOfLife;
}
