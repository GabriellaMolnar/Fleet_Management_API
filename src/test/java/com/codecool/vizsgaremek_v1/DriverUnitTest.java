package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
