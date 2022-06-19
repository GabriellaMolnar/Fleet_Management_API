package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import com.codecool.vizsgaremek_v1.entity.dto.CarValueAddUpdateDto;
import com.codecool.vizsgaremek_v1.service.CarValueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/values")
public class CarValueController {
    private final CarValueService carValueService;

    @Autowired
    public CarValueController(CarValueService carValueService) {
        this.carValueService = carValueService;
    }

    @GetMapping
    @Operation(summary = "Get car values",
            description = "Get values of cars")
    public List<CarValue> getValuesList() {
        return carValueService.getValuesList();
    }

    @GetMapping("/{car_id}")
    @Operation(summary = "Get a car value",
            description = "Get the values of a car by car id")
    public CarValue getValuesOfCar(@PathVariable("car_id") long carId) {
        return carValueService.getValuesOfCar(carId);
    }

    @PostMapping
    @Operation(summary = "Add values",
            description = "Add values")
    public ResponseEntity<?> addNewValuesToACar(@Valid @RequestBody CarValueAddUpdateDto carValueAddUpdateDto,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("invalid car value");
        }
        return ResponseEntity.ok().body(carValueService.addNewValuesToACar(carValueAddUpdateDto));
    }

    @PutMapping("/{car_id}")
    @Operation(summary = "Update value of a car",
            description = "Update values of an an existing car by car id")
    public ResponseEntity<?> updateValuesOfACar(@Valid @RequestBody CarValue carValue, @PathVariable("car_id") long carId,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("invalid car value");
        }
        return ResponseEntity.ok().body(carValueService.updateValuesOfACar(carValue, carId));
    }

    @DeleteMapping("/{car_id}")
    @Operation(summary = "Delete values",
            description = "Delete values of a car")
    public void deleteValuesOfACar(@PathVariable("car_id") long carId) {
        carValueService.deleteValuesOfACar(carId);
    }

    @GetMapping("/net_value")
    @Operation(summary = "Get net values",
            description = "Get net values of existing cars")
    public Map<String, Integer> listOfCarsNetValue() {
        return carValueService.listOfCarsNetValue();
    }

    @GetMapping("/depr")
    @Operation(summary = "Get monthly depreciation",
            description = "Get monthly depreciation and amortisation of cars")
    public Map<String, Integer> listOfMonthlyDepreciation() {
        return carValueService.listOfMonthlyDepreciation();
    }
}
