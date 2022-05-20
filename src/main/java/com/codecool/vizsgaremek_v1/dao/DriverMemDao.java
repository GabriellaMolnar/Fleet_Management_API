package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.model.Driver;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository("driverMemDao")
public class DriverMemDao implements DriverDao {
    private List<Driver> drivers = new ArrayList<>();

    @Override
    public void addDriverWithTheTribeNumber(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public List<Driver> listDrivers() {
        return drivers;
    }

    @Override
    public Driver getDriverByTribeNumber(long tribeNumber) {
        return drivers.stream().filter(e -> e.getTribeNumber() == tribeNumber).findFirst().get();
    }

    @Override
    public void updateDriver(Driver driver, long tribeNumber) {
        Driver driverToMod =  getDriverByTribeNumber(tribeNumber);
        driverToMod.setBirthDate(driver.getBirthDate());
        driverToMod.setMotherName(driver.getMotherName());
        driverToMod.setName(driver.getName());
    }

    @Override
    public void deleteDriver(long tribeNumber) {
        drivers.removeIf(e -> e.getTribeNumber() == tribeNumber);
    }

    @Override
    public List<Driver> getDriverByName(String name) {
        return drivers.stream().filter(e-> e.getName().equals(name)).collect(Collectors.toList());
    }
}
