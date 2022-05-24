package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.dao.DriverDao;
import com.codecool.vizsgaremek_v1.entity.Driver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private DriverDao driverDao;

    public DriverService(@Qualifier("driverMemDao") DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    public void addDriverWithTheTribeNumber(Driver driver) {
        driverDao.addDriverWithTheTribeNumber(driver);
    }

    public List<Driver> listDrivers() {
        return driverDao.listDrivers();
    }

    public Driver getDriverByTribeNumber(long tribeNumber) {
        return driverDao.getDriverByTribeNumber(tribeNumber);
    }

    public void updateDriver(Driver driver, long tribeNumber) {
        driverDao.updateDriver(driver, tribeNumber);
    }

    public void deleteDriver(long tribeNumber) {
        driverDao.deleteDriver(tribeNumber);
    }

    public List<Driver> getDriverByName(String name) {
        return driverDao.getDriverByName(name);
    }
}
