package com.codecool.fleet_management_api.repository;

import com.codecool.fleet_management_api.entity.CarValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarValueRepository extends JpaRepository<CarValue, Long> {
    CarValue findCarValueByCarId(long carId);
}
