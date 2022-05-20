package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverMemDao implements DriverDao {
    @Override
    public void addDriver(Driver driver) {

    }

    @Override
    public List<Driver> listDrivers() {
        return null;
    }

    @Override
    public Driver getDriver(long id) {
        return null;
    }

    @Override
    public void updateDriver(Driver driver, long id) {

    }

    @Override
    public void deleteDriver(long id) {

    }
}
