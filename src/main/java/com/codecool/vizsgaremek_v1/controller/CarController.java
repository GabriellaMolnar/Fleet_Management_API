package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.dto.CarAddUpdateDto;
import com.codecool.vizsgaremek_v1.service.CarService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@OpenAPIDefinition(info = @Info(title = "Fleet Management",
        description = "Manage drivers, cars and these values", version = "v1"))
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @Operation(summary = "Get cars",
            description = "Get list of cars")
    public List<Car> listCars() {
        return carService.listCars();
    }

    @PostMapping
    @Operation(summary = "Add a car",
            description = "Add an new car to your car list")
    public Car addCar(@RequestBody CarAddUpdateDto car) {
        return carService.addCar(car);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a car",
            description = "Get a car by car id")
    public Car getCar(@PathVariable long id) {
        return carService.getCar(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing car",
            description = "Update an existing car by car id")
    public Car updateCar(@RequestBody CarAddUpdateDto car, @PathVariable long id) {
       return carService.updateCar(car, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car",
            description = "Delete a car from your car list")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/reg_num")
    @Operation(summary = "Get a car by registration number",
            description = "Get a car by its registration number")
    public Car getCarByRegistrationNumber(@RequestParam("registration_number") String registrationNumber) {
        return carService.getCarByRegistrationNumber(registrationNumber);
    }

    @GetMapping("/brand")
    @Operation(summary = "Get cars by brand",
            description = "Get cars by brand")
    public List<Car> getCarByBrand(@RequestParam("brand") Brand brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/commercial_vehicles")
    @Operation(summary = "Get commercial vehicles",
            description = "Get commercial vehicles")
    public List<Car> getCommercialVehicles() {
        return carService.getCommercialVehicles();
    }

    @GetMapping("/passenger_cars")
    @Operation(summary = "Get passenger cars",
            description = "Get passenger cars")
    public List<Car> getPassengerCars() {
        return carService.getPassengerCars();
    }

    @GetMapping("/free")
    @Operation(summary = "Get free cars",
            description = "Get free cars, ready to use")
    public List<Car> getFreeCars() {
        return carService.getFreeCars();
    }
}
