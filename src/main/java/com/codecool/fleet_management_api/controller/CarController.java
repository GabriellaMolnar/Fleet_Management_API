package com.codecool.fleet_management_api.controller;

import com.codecool.fleet_management_api.entity.Brand;
import com.codecool.fleet_management_api.entity.Car;
import com.codecool.fleet_management_api.entity.dto.CarAddUpdateDto;
import com.codecool.fleet_management_api.service.CarService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
@OpenAPIDefinition(info = @Info(title = "Fleet Management",
        description = "Manage drivers, cars and these values, and depots", version = "v1"))
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping
    @Operation(summary = "Get cars",
            description = "Get list of cars")
    public List<Car> listCars() {
        return carService.listCars();
    }

    @PostMapping
    @Operation(summary = "Add a car",
            description = "Add an new car to your car list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CarAddUpdateDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    public ResponseEntity<?> addCar(@Valid @RequestBody CarAddUpdateDto carDto, BindingResult bindingResult) {
        ResponseEntity<?> error_message = getResponseEntity(bindingResult);
        if (error_message != null) return error_message;
        logger.info("added new car");
        return ResponseEntity.ok().body(carService.addCar(carDto));
    }

    @GetMapping("/{car_id}")
    @Operation(summary = "Get a car",
            description = "Get a car by car id")
    public Car getCar(@PathVariable ("car_id") long carId) {
        return carService.getCar(carId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing car",
            description = "Update an existing car by car id")
    public ResponseEntity<?> updateCar(@Valid @RequestBody CarAddUpdateDto car, @PathVariable long id,
                                       BindingResult bindingResult) {
        ResponseEntity<?> error_message = getResponseEntity(bindingResult);
        if (error_message != null) return error_message;
        logger.info("successful update");
        return ResponseEntity.ok().body(carService.updateCar(car, id));
    }

    private ResponseEntity<?> getResponseEntity(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder error_message = new StringBuilder();
            error_message.append("invalid car\n");
            bindingResult.getAllErrors().forEach(e -> error_message.append(e.getDefaultMessage()));
            logger.error(String.valueOf(error_message));
            return ResponseEntity.badRequest().body(error_message);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car",
            description = "Delete a car from your car list")
    public void deleteCar(@PathVariable long id) {
        Car carToDelete = carService.getCar(id);
        carService.deleteCar(id);
        logger.info("successful deleting " + carToDelete);
    }

    @GetMapping("/reg_num")
    @Operation(summary = "Get a car by registration number",
            description = "Get a car by its registration number")
    public Car getCarByRegistrationNumber(@RequestParam("registration_number") String registrationNumber) {
        return carService.getCarByRegistrationNumber(registrationNumber);
    }

    @GetMapping("/brand")
    @Operation(summary = "Get cars by brand",
            description = "Get cars by brand")
    public List<Car> getCarByBrand(@RequestParam("brand") Brand brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/commercial_vehicles")
    @Operation(summary = "Get commercial vehicles",
            description = "Get commercial vehicles")
    public List<Car> getCommercialVehicles() {
        return carService.getCommercialVehicles();
    }

    @GetMapping("/passenger_cars")
    @Operation(summary = "Get passenger cars",
            description = "Get passenger cars")
    public List<Car> getPassengerCars() {
        return carService.getPassengerCars();
    }

    @GetMapping("/free")
    @Operation(summary = "Get free cars",
            description = "Get free cars, ready to use")
    public List<Car> getFreeCars() {
        return carService.getFreeCars();
    }
}
