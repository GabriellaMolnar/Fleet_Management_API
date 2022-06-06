package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.dto.CarAddUpdateDto;
import com.codecool.vizsgaremek_v1.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
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
