package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.model.Driver;
import com.codecool.vizsgaremek_v1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> listDrivers() {
        return driverService.listDrivers();
    }

    @PostMapping
    public void addDriverWithTheTribeNumber(@RequestBody Driver driver) {
        driverService.addDriverWithTheTribeNumber(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriverByTribeNumber(@PathVariable long tribeNumber) {
        return driverService.getDriverByTribeNumber(tribeNumber);
    }

    @PutMapping("/{id}")
    public void updateDriver(@RequestBody Driver driver, @PathVariable long tribeNumber) {
        driverService.updateDriver(driver, tribeNumber);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable long tribeNumber) {
        driverService.deleteDriver(tribeNumber);
    }


    @GetMapping("/{name}")
    public List<Driver> getDriverByName(@PathVariable String name) {
        return driverService.getDriverByName(name);
    }
}
