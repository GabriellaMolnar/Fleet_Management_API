package com.codecool.fleet_management_api.service;

import com.codecool.fleet_management_api.entity.*;
import com.codecool.fleet_management_api.entity.dto.CarAddUpdateDto;
import com.codecool.fleet_management_api.repository.CarRepository;
import com.codecool.fleet_management_api.repository.CarValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarValueRepository carValueRepository;

    public CarService(CarRepository carRepository, CarValueRepository carValueRepository) {
        this.carRepository = carRepository;
        this.carValueRepository = carValueRepository;
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public Car addCar(CarAddUpdateDto carAddUpdateDto) {
        Car newCar = new Car();
        newCar.setBrand(carAddUpdateDto.getBrand());
        newCar.setRegistrationNumber(carAddUpdateDto.getRegistrationNumber());
        newCar.setModel(carAddUpdateDto.getModel());
        newCar.setColor(carAddUpdateDto.getColor());
        newCar.setEngineNumber(carAddUpdateDto.getEngineNumber());
        newCar.setPassengerCar(carAddUpdateDto.isPassengerCar());
       return carRepository.save(newCar);
    }

    public Car getCar(long id) {
    return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(CarAddUpdateDto carAddUpdateDto, long id) {
        Car carToUpdate = carRepository.findById(id).orElse(null);
        if (carToUpdate!=null){
            carToUpdate.setRegistrationNumber(carAddUpdateDto.getRegistrationNumber());
            carToUpdate.setBrand(carAddUpdateDto.getBrand());
            carToUpdate.setModel(carAddUpdateDto.getModel());
            carToUpdate.setColor(carAddUpdateDto.getColor());
            carToUpdate.setEngineNumber(carAddUpdateDto.getEngineNumber());
            carToUpdate.setPassengerCar(carAddUpdateDto.isPassengerCar());
        }
      return carRepository.save(carToUpdate);
    }

    public void deleteCar(long id) {
        Car car = carRepository.findById(id).orElse(null);
        car.setDriver(null);
        car.setDepot(null);
        if (carValueRepository.findById(id).isPresent()) {
            carValueRepository.deleteById(carValueRepository.findById(id).get().getCarId());
        }
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
       return carRepository.getFreeCars();
    }
}
