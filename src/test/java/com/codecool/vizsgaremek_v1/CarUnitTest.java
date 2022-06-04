package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarUnitTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "http://localhost:8080/cars";

    @Test
    public void CarListTest() {
        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url, Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] cars = response.getBody();
        assert cars != null;
        assertEquals(4, cars.length);
    }

    @Test
    public void getACarTest() {
        final ResponseEntity<Car> response = restTemplate.getForEntity(url + "/" + 3, Car.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car receivedCar = response.getBody();
        assert receivedCar != null;
        assertEquals(3, receivedCar.getId());
        assertEquals("RIT-123", receivedCar.getRegistrationNumber());
        assertEquals(Brand.AUDI, receivedCar.getBrand());
        assertEquals("A3", receivedCar.getModel());
        assertEquals("yellow", receivedCar.getColor());
        assertEquals("654678", receivedCar.getEngineNumber());
        assertTrue(receivedCar.isPassengerCar());
        assertNull(receivedCar.getDriver());
        assertTrue(receivedCar.isPassengerCar());
    }

    @Test
    public void getACarTestByRegistraionNumberPUS111() {
        final ResponseEntity<Car> response = restTemplate.getForEntity(url + "?registration_number=PUS-111", Car.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car receivedCar = response.getBody();
        assert receivedCar != null;
        assertEquals(2, receivedCar.getId());
    }

    @Test
    public void getCommercialVehicles() {
        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url + "/commercial_vehicles", Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] cars = response.getBody();
        assert cars != null;
        assertEquals(1, cars.length);
    }

    @Test
    public void getPassengerCars() {
        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url + "/passenger_cars", Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] cars = response.getBody();
        assert cars != null;
        assertEquals(3, cars.length);
    }

    @Test
    public void getFreeCars() {
        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url + "/free", Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] cars = response.getBody();
        assert cars != null;
        assertEquals(2, cars.length);
    }

}
