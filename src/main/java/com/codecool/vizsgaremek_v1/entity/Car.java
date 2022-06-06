package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "registrationNumber")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "registration number required")
    @Column(name = "registration_number")
    private String registrationNumber;

   // @NotBlank(message = "Brand required")
    @Enumerated(EnumType.STRING)
    @Column(name = "brand", length = 20)
    private Brand brand;
    private String model;
    private String color;
    @Column(name = "engine_number")
    private String engineNumber;
    @Column(name = "passenger_car")
    boolean passengerCar;

    @ManyToOne
    @JoinColumn(name = "driver_tribeNumber", referencedColumnName = "tribeNumber")
    @JsonIdentityReference(alwaysAsId = true)
    private Driver driver;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CarValue carValue;
}
