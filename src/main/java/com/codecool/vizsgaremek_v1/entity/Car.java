package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(name = "registration_number")
    private String registrationNumber;
   // @NotBlank
    private Brand brand;
    private String model;
    private String color;
    @Column(name = "engine_number")
    private String engineNumber;
    @Column(name = "passenger_car")
    boolean passengerCar;

    @ManyToOne
    @JsonBackReference
    private Driver driver;
}
