package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.model.Driver;

import java.util.List;

public interface DriverDao {
    void addDriver(Driver driver);

    List<Driver> listDrivers();

    Driver getDriver(long id);

    void updateDriver(Driver driver, long id);

    void deleteDriver(long id);
}
