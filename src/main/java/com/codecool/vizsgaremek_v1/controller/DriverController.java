package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.Driver;
import com.codecool.vizsgaremek_v1.entity.dto.DriverAddUpdateDto;
import com.codecool.vizsgaremek_v1.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

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
    public Driver addDriverWithTheTribeNumber(@RequestBody DriverAddUpdateDto driver) {
        return driverService.addDriverWithTheTribeNumber(driver);
    }

    @GetMapping("/{tribe_number}")
    @Operation(summary = "Get a driver",
            description = "Get a driver by driver tribe number")
    public Driver getDriverByTribeNumber(@PathVariable("tribe_number") long tribeNumber) {
        return driverService.getDriverByTribeNumber(tribeNumber);
    }

    @PutMapping("/{tribe_number}")
    @Operation(summary = "Update an existing driver",
            description = "Update an existing driver by driver tribe number")
    public Driver updateDriver(@RequestBody DriverAddUpdateDto driver, @PathVariable("tribe_number") long tribeNumber) {
        return driverService.updateDriver(driver, tribeNumber);
    }

    @DeleteMapping("/{tribe_number}")
    @Operation(summary = "Delete a driver",
            description = "Delete a driver from your driver list")
    public void deleteDriver(@PathVariable("tribe_number") long tribeNumber) {
        driverService.deleteDriver(tribeNumber);
    }


    @GetMapping("/name")
    @Operation(summary = "Get drivers by name",
            description = "Get drivers by name")
    public List<Driver> getDriverByName(@RequestParam("name") String name) {
        return driverService.getDriverByName(name);
    }
}
