package com.codecool.fleet_management_api;

import com.codecool.fleet_management_api.entity.dto.DepotAddDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DepotIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String url = "http://localhost:8080/depots";


    @Test
    public void DepotListAddAndDeleteTest() {
        final ResponseEntity<DepotTestDto[]> response = restTemplate.getForEntity(url, DepotTestDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final DepotTestDto[] depots = response.getBody();
        assert depots != null;
        assertEquals(1, depots.length);

        DepotAddDto newDepot = new DepotAddDto("Piripócs", "Zsák utca 5.");
        postDepot(newDepot);
        final ResponseEntity<DepotTestDto[]> postResponse = restTemplate.getForEntity(url, DepotTestDto[].class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(2, postResponse.getBody().length);

        restTemplate.delete(url + "/" + 2, DepotTestDto.class);
        final ResponseEntity<DepotTestDto[]> responseAfterDelete = restTemplate.getForEntity(url, DepotTestDto[].class);
        final DepotTestDto[] depots3 = responseAfterDelete.getBody();
        assertEquals(HttpStatus.OK, responseAfterDelete.getStatusCode());
        assertEquals(1, depots3.length);
    }

    private void postDepot(DepotAddDto newDepot) {
        final HttpEntity<DepotAddDto> httpEntity = createHttpEntityWithMediatypeJson(newDepot);
        ResponseEntity<DepotAddDto> postResponse = restTemplate.postForEntity(url, httpEntity, DepotAddDto.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    private HttpEntity<DepotAddDto> createHttpEntityWithMediatypeJson(DepotAddDto depot) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(depot, headers);
    }

    @Test
    public void getADepotTest() {
        final ResponseEntity<DepotTestDto> response = restTemplate.getForEntity(url + "/" + 1, DepotTestDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final DepotTestDto receivedDepot = response.getBody();
        assert receivedDepot != null;
        assertEquals(1, receivedDepot.getId());
        assertEquals("Our main depot", receivedDepot.getDepotName());
        assertEquals("Kiskunfélegyháza, Fő utca 2.", receivedDepot.getAddress());
    }

    @Test
    public void addNotValidDepotTest() {
        DepotAddDto badDepot = new DepotAddDto("", "Szabadság u. 4");
        final HttpEntity<DepotAddDto> httpEntity = createHttpEntityWithMediatypeJson(badDepot);
        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, httpEntity, String.class);
        assertEquals("400 BAD_REQUEST", postResponse.getStatusCode().toString());
        assertEquals("invalid depot", postResponse.getBody());
    }
}
