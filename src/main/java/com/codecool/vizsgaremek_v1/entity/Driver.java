package com.codecool.vizsgaremek_v1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Driver {

    @Id
   // @NotBlank
   // @Length(min = 5, max = 6)
   // @Pattern(regexp = "[0-9]")
    private long tribeNumber;

    @Length(min = 5, max = 50)
  //  @Pattern(regexp = "[A-Z].+[^0-9]")
    private String name;

    private LocalDate birthDate;

    @Length(min = 5, max = 50)
  //  @Pattern(regexp = "[A-Z].+[^0-9]")
    private String motherName;

    @OneToMany(mappedBy = "driver")
    @JsonManagedReference
    private List<Car> cars;
}
