package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DriverUnitTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "http://localhost:8080/drivers";

    @Test
    public void findAllDriverTest() {
        final ResponseEntity<Driver[]> response = restTemplate.getForEntity(url, Driver[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Driver[] drivers = response.getBody();
        assert drivers != null;
        assertEquals(2, drivers.length);
    }

    @Test
    public void getADriverTest() {
        final ResponseEntity<Driver> response = restTemplate.getForEntity(url + "/" + 222222, Driver.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Driver receivedDriver = response.getBody();
        assert receivedDriver != null;
        assertEquals(222222, receivedDriver.getTribeNumber());
        assertEquals("Kovács István", receivedDriver.getName());
        assertEquals(LocalDate.of(1980, 3, 25), receivedDriver.getBirthDate());
        assertEquals("Lapos Julianna", receivedDriver.getMotherName());
        assertEquals(222222, receivedDriver.getTribeNumber());
    }
}
