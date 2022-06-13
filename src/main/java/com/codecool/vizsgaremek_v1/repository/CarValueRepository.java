package com.codecool.vizsgaremek_v1.repository;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarValueRepository extends JpaRepository<CarValue, Long> {
    CarValue findCarValueByCarId(long carId);
}
