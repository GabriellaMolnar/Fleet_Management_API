package com.codecool.fleet_management_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarValueIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "http://localhost:8080/values";

    @Test
    public void CarValueListTest() {
        final ResponseEntity<CarValueTestDto[]> response = restTemplate.getForEntity(url, CarValueTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarValueTestDto[] carValues = response.getBody();
        assert carValues != null;
        assertEquals(4, carValues.length);
    }

    @Test
    public void getACarValueTest() {
        final ResponseEntity<CarValueTestDto> response = restTemplate.getForEntity(url + "/" + 1, CarValueTestDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarValueTestDto receivedCarValue = response.getBody();
        assert receivedCarValue != null;
        assertEquals(1, receivedCarValue.getCarId());
        assertEquals(20000000, receivedCarValue.getGrossValue());
        assertEquals(LocalDate.of(2020, 6, 1), receivedCarValue.getEntryDate());
        assertEquals(LocalDate.of(2024, 6, 1), receivedCarValue.getPlannedEndOfLife());
        assertEquals(4000000, receivedCarValue.getPriceEndOfLife());
    }

}
