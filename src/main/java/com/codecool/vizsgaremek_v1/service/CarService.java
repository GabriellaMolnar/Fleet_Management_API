package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.dao.CarDao;
import com.codecool.vizsgaremek_v1.model.Brand;
import com.codecool.vizsgaremek_v1.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> listCars() {
        return carDao.listCars();
    }

    public void addCar(Car car) {
        carDao.addCar(car);
    }

    public Car getCar(long id) {
        return carDao.getCar(id);
    }

    public void updateCar(Car car, long id) {
        carDao.updateCar(car, id);
    }

    public void deleteCar(long id) {
        carDao.deleteCar(id);
    }

    public Car getCarByRegistrationNumber(String registrationNumber) {
        return carDao.getCarByRegistrationNumber(registrationNumber);
    }

    public List<Car> getCarByBrand(Brand brand) {
        return carDao.getCarByBrand(brand);
    }

    public List<Car> getCommercialVehicles() {
        return carDao.getCommercialVehicles();
    }

    public List<Car> getPassengerCars() {
        return carDao.getPassengerCars();
    }

    public List<Car> getFreeCars() {
        return carDao.getFreeCars();
    }
}
