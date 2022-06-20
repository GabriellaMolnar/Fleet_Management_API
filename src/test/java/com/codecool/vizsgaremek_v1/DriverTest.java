package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.dto.DriverAddUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DriverTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "http://localhost:8080/drivers";

    @Test
    public void findAllDriverAddAndDeleteDriverTest() {
        final ResponseEntity<DriverTestDto[]> response = restTemplate.getForEntity(url, DriverTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final DriverTestDto[] drivers = response.getBody();
        assert drivers != null;
        assertEquals(2, drivers.length);

        DriverAddUpdateDto newDriver = new DriverAddUpdateDto(333333, "Vak Cina", LocalDate.of(2001, 05, 05), "Ős Iza");
        postDriver(newDriver);
        final ResponseEntity<DriverTestDto[]> postResponse = restTemplate.getForEntity(url, DriverTestDto[].class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(3, postResponse.getBody().length);

        restTemplate.delete(url + "/" + 333333, DriverTestDto.class);
        final ResponseEntity<DriverTestDto[]> responseAfterDelete = restTemplate.getForEntity(url, DriverTestDto[].class);
        final DriverTestDto[] drivers3 = responseAfterDelete.getBody();
        assertEquals(HttpStatus.OK, responseAfterDelete.getStatusCode());
        assertEquals(2, drivers3.length);

    }

    private void postDriver(DriverAddUpdateDto newDriver) {
        final HttpEntity<DriverAddUpdateDto> httpEntity = createHttpEntityWithMediatypeJson(newDriver);
        ResponseEntity<DriverAddUpdateDto> postResponse = restTemplate.postForEntity(url, httpEntity, DriverAddUpdateDto.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    private HttpEntity<DriverAddUpdateDto> createHttpEntityWithMediatypeJson(DriverAddUpdateDto driver) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(driver, headers);
    }

    @Test
    public void addNotValidDriverTest() {
        DriverAddUpdateDto invalidDriver = new DriverAddUpdateDto(333333, "Vak Cina", LocalDate.of(2055, 05, 05), "Ős Iza");
        final HttpEntity<DriverAddUpdateDto> httpEntity = createHttpEntityWithMediatypeJson(invalidDriver);
        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, httpEntity, String.class);
        assertEquals("400 BAD_REQUEST", postResponse.getStatusCode().toString());
        assertEquals("invalid driver", postResponse.getBody());
    }

    @Test
    public void getADriverTest() {
        final ResponseEntity<DriverTestDto> response = restTemplate.getForEntity(url + "/" + 222222, DriverTestDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final DriverTestDto receivedDriver = response.getBody();
        assert receivedDriver != null;
        assertEquals(222222, receivedDriver.getTribeNumber());
        assertEquals("Kovács István", receivedDriver.getName());
        assertEquals(LocalDate.of(1980, 3, 25), receivedDriver.getBirthDate());
        assertEquals("Lapos Julianna", receivedDriver.getMotherName());
        assertEquals(222222, receivedDriver.getTribeNumber());
    }

    @Test
    public void getADriverTestNameKovácsIstván() {
        final ResponseEntity<DriverTestDto[]> response = restTemplate.getForEntity(url + "/name?name=Kovács István", DriverTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final DriverTestDto[] receivedDrivers = response.getBody();
        assert receivedDrivers != null;
        assertEquals(222222, receivedDrivers[0].getTribeNumber());
    }
}
