package com.codecool.vizsgaremek_v1.repository;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findAllCarByRegistrationNumber(String registrationNumber);

    List<Car> findAllCarByBrand(Brand brand);

    @Query("SELECT a FROM Car a WHERE a.passengerCar = true ")
    List<Car> findPassengerCars();

    @Query("SELECT a FROM Car a WHERE a.passengerCar = false ")
    List<Car> getCommercialVehicles();
}
