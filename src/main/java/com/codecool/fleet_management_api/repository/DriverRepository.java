package com.codecool.fleet_management_api.repository;


import com.codecool.fleet_management_api.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository  extends JpaRepository<Driver, Long> {
    @Query("SELECT d FROM Driver d WHERE d.tribeNumber = ?1 ")
    Driver getDriverByTribeNumber(long tribeNumber);

    @Query("SELECT d FROM Driver d WHERE d.name = ?1 ")
    List<Driver> getDriverByName(String name);
}
