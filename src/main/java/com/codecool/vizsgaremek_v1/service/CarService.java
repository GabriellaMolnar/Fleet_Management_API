package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public Car getCar(long id) {
    return carRepository.findById(id).orElse(null);
    }

    public void updateCar(Car car, long id) {
        //TODO
        //  carRepository.updateCar(car, id);
    }

    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    public Car getCarByRegistrationNumber(String registrationNumber) {
        return carRepository.findAllCarByRegistrationNumber(registrationNumber);
    }

    public List<Car> getCarByBrand(Brand brand) {
        return carRepository.findAllCarByBrand(brand);
    }

    public List<Car> getCommercialVehicles() {
         return carRepository.getCommercialVehicles();
    }

    public List<Car> getPassengerCars() {
        return carRepository.findPassengerCars();
    }

    public List<Car> getFreeCars() {
        return null;
        //TODO
        // return carRepository.getFreeCars();
    }
}
