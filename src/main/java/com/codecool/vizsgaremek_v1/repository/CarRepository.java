package com.codecool.vizsgaremek_v1.repository;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.registrationNumber = ?1 ")
    Car findAllCarByRegistrationNumber(String registrationNumber);

    List<Car> findAllCarByBrand(Brand brand); //TODO

    @Query("SELECT c FROM Car c WHERE c.passengerCar = true ")
    List<Car> findPassengerCars();

    @Query("SELECT c FROM Car c WHERE c.passengerCar = false ")
    List<Car> getCommercialVehicles();

    @Query("SELECT c FROM Car c WHERE c.driver IS NULL ")
    List<Car> getFreeCars();

}
