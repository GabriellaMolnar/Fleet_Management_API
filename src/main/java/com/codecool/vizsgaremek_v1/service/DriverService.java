package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.dao.DriverDao;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private DriverDao driverDao;

    public DriverService(DriverDao driverDao) {
        this.driverDao = driverDao;
    }
}
