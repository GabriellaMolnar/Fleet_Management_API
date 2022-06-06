package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "netValue")
public class CarValue {
    @Id
   // @NotBlank
    @Column(name = "car_id")
    private long carId;
    @Column(name = "entry_date")
    private LocalDate entryDate;

    private int grossValue;
    private int netValue;
    private LocalDate plannedEndOfLife;

   // @Length(max = 8)
    // @Pattern(regexp = "[0-9]")
    private int priceEndOfLife;

    @OneToOne
    @MapsId
    @JsonIdentityReference(alwaysAsId = true)
  //  @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
