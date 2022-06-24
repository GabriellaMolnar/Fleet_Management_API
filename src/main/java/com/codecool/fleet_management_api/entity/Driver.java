package com.codecool.fleet_management_api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Driver {

    @Id
    private long tribeNumber;
    private String name;
    private LocalDate birthDate;
    private String motherName;

    @OneToMany(mappedBy = "driver")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Car> cars = new ArrayList<>();
}
