package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.dto.CarAddUpdateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarUnitTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static  CarAddUpdateDto[] CARS_CAN_BE_ADD;
    private final String url = "http://localhost:8080/cars";

    @Test
    public void CarListTest() {
        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url, Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] cars = response.getBody();
        assert cars != null;
        assertEquals(4, cars.length);
    }
/*  nem jó //TODO
    void addOrUpdate() {
        CARS_CAN_BE_ADD = new CarAddUpdateDto[]{
                new CarAddUpdateDto("RIT-789", Brand.ALFA_ROMEO, "Civic", "pink", "ggggggggggggg", true),
                new CarAddUpdateDto("GEG-111", Brand.JAGUAR, "4444", "brown", "vvvvvvvvv", true)
        };
    }

    void postCar(String url, CarAddUpdateDto car) {
        addOrUpdate();
        final HttpEntity<CarAddUpdateDto> httpEntity = createHttpEntityWithMediatypeJson(car);
        final ResponseEntity<Long> postResponse = restTemplate.postForEntity(url, httpEntity, Long.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    private HttpEntity<CarAddUpdateDto> createHttpEntityWithMediatypeJson(CarAddUpdateDto car) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(car, headers);
    }

    @Test
    void givenNewCarPostedWhenCarRetrievedThenReturnsContent() {
        final Car[] result = restTemplate.getForObject(url, Car[].class);
        assertEquals(4, result.length);

        postCar(url, CARS_CAN_BE_ADD[0]);

        final ResponseEntity<Car[]> response = restTemplate.getForEntity(url, Car[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final Car[] car = response.getBody();
       assertEquals(5, car.length);
      assertEquals(CARS_CAN_BE_ADD[0].getBrand(), car[4].getBrand() );
    }
 */
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
