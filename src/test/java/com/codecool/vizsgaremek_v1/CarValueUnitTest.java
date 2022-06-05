package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarValueUnitTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "http://localhost:8080/values";

    @Test
    public void CarValueListTest() {
        final ResponseEntity<CarValue[]> response = restTemplate.getForEntity(url, CarValue[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarValue[] carValues = response.getBody();
        assert carValues != null;
        assertEquals(2, carValues.length);
    }

    @Test
    public void getACarValueTest() {
        final ResponseEntity<CarValue> response = restTemplate.getForEntity(url + "/" + 1, CarValue.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarValue receivedCarValue = response.getBody();
        assert receivedCarValue != null;
        assertEquals(1, receivedCarValue.getCarId());
        assertEquals(9000000, receivedCarValue.getGrossValue());
        assertEquals(LocalDate.of(2020, 6, 1), receivedCarValue.getEntryDate());
        assertEquals(LocalDate.of(2024, 6, 1), receivedCarValue.getPlannedEndOfLife());
        assertEquals(3000000, receivedCarValue.getPriceEndOfLife());
    }

    @Test
    public void getNetValues() {
        //TODO
        final ResponseEntity<Integer[]> response = restTemplate.getForEntity(url + "/net_value", Integer[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Integer[] carNetValues = response.getBody();
        assert carNetValues != null;
        assertEquals(2, carNetValues.length);
    }
}
