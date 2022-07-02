package com.codecool.fleet_management_api;

import com.codecool.fleet_management_api.entity.Brand;
import com.codecool.fleet_management_api.entity.dto.CarAddUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String url = "http://localhost:8080/cars";

    private void postCar(CarAddUpdateDto newCar) {
        final HttpEntity<CarAddUpdateDto> httpEntity = createHttpEntityWithMediatypeJson(newCar);
        ResponseEntity<CarAddUpdateDto> postResponse = restTemplate.postForEntity(url, httpEntity, CarAddUpdateDto.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    private HttpEntity<CarAddUpdateDto> createHttpEntityWithMediatypeJson(CarAddUpdateDto car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(car, headers);
    }

    @Test
    public void CarListAddAndDeleteACarTest() {
        final ResponseEntity<CarTestDto[]> response = restTemplate.getForEntity(url, CarTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto[] cars = response.getBody();
        assert cars != null;
        assertEquals(5, cars.length);

        CarAddUpdateDto newCar = new CarAddUpdateDto("RIT-789", Brand.ALFA_ROMEO, "Civic", "pink", "ggggggggggggg", true);
        postCar(newCar);
        final ResponseEntity<CarTestDto[]> postResponse = restTemplate.getForEntity(url, CarTestDto[].class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(6, postResponse.getBody().length);

        restTemplate.delete(url + "/" + 5, CarTestDto.class);
        final ResponseEntity<CarTestDto[]> responseAfterDelete = restTemplate.getForEntity(url, CarTestDto[].class);
        final CarTestDto[] cars3 = responseAfterDelete.getBody();
        assertEquals(HttpStatus.OK, responseAfterDelete.getStatusCode());
        assertEquals(5, cars3.length);
    }

    @Test
    public void addNotValidCarTest() {
        CarAddUpdateDto badCar = new CarAddUpdateDto("GE", Brand.JAGUAR, "4444", "brown", "vvvvvvvvv", true);
        final HttpEntity<CarAddUpdateDto> httpEntity = createHttpEntityWithMediatypeJson(badCar);
        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, httpEntity, String.class);
        assertEquals("400 BAD_REQUEST", postResponse.getStatusCode().toString());
    }

    @Test
    public void getACarTest() {
        final ResponseEntity<CarTestDto> response = restTemplate.getForEntity(url + "/" + 3, CarTestDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto receivedCar = response.getBody();
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
    public void getACarTestByRegistrationNumberPUS111() {
        final ResponseEntity<CarTestDto> response = restTemplate.getForEntity(url + "/reg_num?registration_number=PUS-111", CarTestDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto receivedCar = response.getBody();
        assert receivedCar != null;
        assertEquals(2, receivedCar.getId());
    }

    @Test
    public void getVehiclesByBrandTest() {
        final ResponseEntity<CarTestDto[]> response = restTemplate.getForEntity(url + "/brand?brand=HONDA", CarTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto[] cars = response.getBody();
        assert cars != null;
        assertEquals(1, cars.length);
        assertEquals("ABC-345", cars[0].getRegistrationNumber());
    }

    @Test
    public void getCommercialVehicles() {
        final ResponseEntity<CarTestDto[]> response = restTemplate.getForEntity(url + "/commercial_vehicles", CarTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto[] cars = response.getBody();
        assert cars != null;
        assertEquals(1, cars.length);
    }

    @Test
    public void getPassengerCars() {
        final ResponseEntity<CarTestDto[]> response = restTemplate.getForEntity(url + "/passenger_cars", CarTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto[] cars = response.getBody();
        assert cars != null;
        assertEquals(4, cars.length);
    }

    @Test
    public void getFreeCars() {
        final ResponseEntity<CarTestDto[]> response = restTemplate.getForEntity(url + "/free", CarTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final CarTestDto[] cars = response.getBody();
        assert cars != null;
        assertEquals(3, cars.length);
    }
}
