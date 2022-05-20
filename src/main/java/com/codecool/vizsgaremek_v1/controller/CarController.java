package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.model.Brand;
import com.codecool.vizsgaremek_v1.model.Car;
import com.codecool.vizsgaremek_v1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> listCars() {
        return carService.listCars();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id) {
        return carService.getCar(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable long id) {
        carService.updateCar(car, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/{registration_number}")
    public Car getCarByRegistrationNumber(@PathVariable String registrationNumber) {
        return carService.getCarByRegistrationNumber(registrationNumber);
    }

    @GetMapping("/{brand}")
    public List<Car> getCarByBrand(@PathVariable Brand brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/commercial_vehicles")
    public List<Car> getCommercialVehicles() {
        return carService.getCommercialVehicles();
    }

    @GetMapping("/passenger_cars")
    public List<Car> getPassengerCars() {
        return carService.getPassengerCars();
    }

    @GetMapping("/free")
    public List<Car> getFreeCars() {
        return carService.getFreeCars();
    }
}
