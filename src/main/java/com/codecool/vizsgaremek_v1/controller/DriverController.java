package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.Driver;
import com.codecool.vizsgaremek_v1.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get drivers",
            description = "Get list of drivers")
    public List<Driver> listDrivers() {
        return driverService.listDrivers();
    }

    @PostMapping
    @Operation(summary = "Add a driver",
            description = "Add an new driver to your driver list")
    public void addDriverWithTheTribeNumber(@RequestBody Driver driver) {
        driverService.addDriverWithTheTribeNumber(driver);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a driver",
            description = "Get a driver by driver tribe number")
    public Driver getDriverByTribeNumber(@PathVariable long tribeNumber) {
        return driverService.getDriverByTribeNumber(tribeNumber);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing driver",
            description = "Update an existing driver by driver tribe number")
    public void updateDriver(@RequestBody Driver driver, @PathVariable long tribeNumber) {
        driverService.updateDriver(driver, tribeNumber);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a driver",
            description = "Delete a driver from your driver list")
    public void deleteDriver(@PathVariable long tribeNumber) {
        driverService.deleteDriver(tribeNumber);
    }


    @GetMapping("/{name}")
    @Operation(summary = "Get drivers by name",
            description = "Get drivers by name")
    public List<Driver> getDriverByName(@PathVariable String name) {
        return driverService.getDriverByName(name);
    }
}
