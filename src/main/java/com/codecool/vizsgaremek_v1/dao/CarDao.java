package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.model.Brand;
import com.codecool.vizsgaremek_v1.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car);

    List<Car> listCars();

    Car getCar(long id);

    void updateCar(Car car, long id);

    void deleteCar(long id);

    Car getCarByRegistrationNumber(String registrationNumber);

    List<Car> getCarByBrand(Brand brand);

    List<Car> getCommercialVehicles();

    List<Car> getPassengerCars();

    List<Car> getFreeCars();
}
