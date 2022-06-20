package com.codecool.vizsgaremek_v1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepotTestDto {
    private long id;
    private String depotName;
    private String address;
    private List<String> cars = new ArrayList<>();
}
