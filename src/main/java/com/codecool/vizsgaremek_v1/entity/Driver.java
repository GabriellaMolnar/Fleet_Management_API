package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Car> cars = new ArrayList<>();
}
