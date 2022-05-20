package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.model.CarValue;
import com.codecool.vizsgaremek_v1.service.CarValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/value")
public class CarValueController {
    private final CarValueService carValueService;

    @Autowired
    public CarValueController(CarValueService carValueService) {
        this.carValueService = carValueService;
    }

    @GetMapping
    public List<CarValue> getValuesList() {
        return carValueService.getValuesList();
    }

    @GetMapping("/{car_id}")
    public CarValue getValuesOfCar(@PathVariable("car_id") long carId) {
        return carValueService.getValuesOfCar(carId);
    }

    @PostMapping
    public void addNewValuesToACar(@RequestBody CarValue carValue) {
        carValueService.addNewValuesToACar(carValue);
    }
    @PutMapping("/{car_id}")
    public void updateValuesOfACar(@RequestBody CarValue carValue, @PathVariable("car_id") long carId) {
        carValueService.updateValuesOfACar(carValue, carId);
    }
    @DeleteMapping("/{car_id}")
    public void deleteValuesOfACar(@PathVariable("car_id") long carId) {
        carValueService.deleteValuesOfACar(carId);
    }

    @GetMapping("/net_value")
    public Map<Long, Integer> listOfCarsNetValue() {
        return carValueService.listOfCarsNetValue();
    }
    @GetMapping("/depr")
    public Map<Long, Integer> listOfMonthlyDepreciation() {
        return carValueService.listOfMonthlyDepreciation();
    }
}
