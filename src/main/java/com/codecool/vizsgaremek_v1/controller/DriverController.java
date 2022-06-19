package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.Driver;
import com.codecool.vizsgaremek_v1.entity.dto.DriverAddUpdateDto;
import com.codecool.vizsgaremek_v1.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping
    @Operation(summary = "Get drivers",
            description = "Get list of drivers")
    public List<Driver> listDrivers() {
        return driverService.listDrivers();
    }

    @PostMapping
    @Operation(summary = "Add a driver",
            description = "Add an new driver to your driver list")
    public ResponseEntity<?> addDriverWithTheTribeNumber(@Valid @RequestBody DriverAddUpdateDto driverDto,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("invalid driver");
            bindingResult.getAllErrors().forEach(e -> logger.error(e.getDefaultMessage()));
            return ResponseEntity.badRequest().body("invalid driver");
        }
        return ResponseEntity.ok().body(driverService.addDriverWithTheTribeNumber(driverDto));
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
    public ResponseEntity<?> updateDriver(@Valid @RequestBody DriverAddUpdateDto driver, @PathVariable("tribe_number") long tribeNumber,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("invalid driver");
            bindingResult.getAllErrors().forEach(e -> logger.error(e.getDefaultMessage()));
            return ResponseEntity.badRequest().body("invalid driver");
        }
        return ResponseEntity.ok().body(driverService.updateDriver(driver, tribeNumber));
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
