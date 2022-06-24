package com.codecool.fleet_management_api.service;

import com.codecool.fleet_management_api.entity.Driver;
import com.codecool.fleet_management_api.entity.dto.DriverAddUpdateDto;
import com.codecool.fleet_management_api.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriverWithTheTribeNumber(DriverAddUpdateDto driverDto) {
        Driver newDriver = new Driver();
        newDriver.setTribeNumber(driverDto.getTribeNumber());
        newDriver.setName(driverDto.getName());
        newDriver.setMotherName(driverDto.getMotherName());
        newDriver.setBirthDate(driverDto.getBirthDate());
       return driverRepository.save(newDriver);
    }

    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverByTribeNumber(long tribeNumber) {
        return driverRepository.getDriverByTribeNumber(tribeNumber);
    }

    public Driver updateDriver(DriverAddUpdateDto driver, long tribeNumber) {
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
