package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.model.Brand;
import com.codecool.vizsgaremek_v1.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarJMemDao implements CarDao {

    private List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> listCars() {
        return cars;
    }

    @Override
    public Car getCar(long id) {
        return cars.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    @Override
    public void updateCar(Car car, long id) {
        Car carToModify = getCar(id);
        carToModify.setBrand(car.getBrand());
        carToModify.setColor(car.getColor());
        carToModify.setPassengerCar(car.isPassengerCar());
        carToModify.setModel(car.getModel());
        carToModify.setEngineNumber(car.getEngineNumber());
        carToModify.setRegistrationNumber(car.getRegistrationNumber());
    }

    @Override
    public void deleteCar(long id) {
        cars.removeIf(e -> e.getId() == id);
    }

    @Override
    public Car getCarByRegistrationNumber(String registrationNumber) {
        return cars.stream().filter(e -> e.getRegistrationNumber().equals(registrationNumber)).findFirst().get();
    }

    @Override
    public List<Car> getCarByBrand(Brand brand) {
        return cars.stream().filter(e-> e.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCommercialVehicles() {
        return cars.stream().filter(e-> !e.isPassengerCar()).collect(Collectors.toList());
    }

    @Override
    public List<Car> getPassengerCars() {
        return cars.stream().filter(e-> e.isPassengerCar()).collect(Collectors.toList());
    }

    @Override
    public List<Car> getFreeCars() {
        //TODO
        return null;
    }
}
