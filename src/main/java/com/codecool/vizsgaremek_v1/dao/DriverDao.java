package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.entity.Driver;

import java.util.List;

public interface DriverDao {
    void addDriverWithTheTribeNumber(Driver driver);

    List<Driver> listDrivers();

    Driver getDriverByTribeNumber(long tribeNumber);

    void updateDriver(Driver driver, long tribeNumber);

    void deleteDriver(long tribeNumber);

    List<Driver> getDriverByName(String name);
}
