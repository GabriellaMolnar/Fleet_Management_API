package com.codecool.fleet_management_api.repository;

import com.codecool.fleet_management_api.entity.Brand;
import com.codecool.fleet_management_api.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.registrationNumber = ?1 ")
    Car findAllCarByRegistrationNumber(String registrationNumber);

    @Query("SELECT c FROM Car c WHERE c.brand = ?1 ")
    List<Car> findAllCarByBrand(Brand brand);

    @Query("SELECT c FROM Car c WHERE c.passengerCar = true ")
    List<Car> findPassengerCars();

    @Query("SELECT c FROM Car c WHERE c.passengerCar = false ")
    List<Car> getCommercialVehicles();

    @Query("SELECT c FROM Car c WHERE c.driver IS NULL ")
    List<Car> getFreeCars();

}
