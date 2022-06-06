package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "netValue")
public class CarValue {
    @Id
    @Column(name = "car_id")
    private long carId;
    @Column(name = "entry_date")
    private LocalDate entryDate;
    private int grossValue;
    private LocalDate plannedEndOfLife;
    private int priceEndOfLife;
    private int netValue;
    private int monthlyDepr;

    @OneToOne
    @MapsId
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
