package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.dao.DriverDao;
import com.codecool.vizsgaremek_v1.entity.Driver;
import com.codecool.vizsgaremek_v1.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriverWithTheTribeNumber(Driver driver) {
       return driverRepository.save(driver);
    }

    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverByTribeNumber(long tribeNumber) {
        return driverRepository.getDriverByTribeNumber(tribeNumber);
    }

    public Driver updateDriver(Driver driver, long tribeNumber) {
        Driver updatedDriver = driverRepository.findById(tribeNumber).orElse(null);
        updatedDriver.setBirthDate(driver.getBirthDate());
        updatedDriver.setName(driver.getName());
        updatedDriver.setMotherName(driver.getMotherName());
        return driverRepository.save(updatedDriver);
    }

    public void deleteDriver(long tribeNumber) {
        driverRepository.deleteById(tribeNumber);
    }

    public List<Driver> getDriverByName(String name) {
        return driverRepository.getDriverByName(name);
    }
}
