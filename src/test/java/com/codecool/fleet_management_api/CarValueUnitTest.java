package com.codecool.fleet_management_api;

import com.codecool.fleet_management_api.controller.CarValueController;
import com.codecool.fleet_management_api.entity.CarValue;
import com.codecool.fleet_management_api.service.CarValueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarValueController.class)
public class CarValueUnitTest {

    @MockBean
    private CarValueService carValueService;

    @Autowired
    private MockMvc mockMvc;

    private final CarValue carValue1 = new CarValue();
    private final CarValue carValue2 = new CarValue();

    @BeforeEach
    public void init() {
        carValue1.setCarId(1L);
        carValue1.setEntryDate(LocalDate.of(2010, 2, 1));
        carValue1.setGrossValue(12000000);
        carValue1.setPlannedEndOfLife(LocalDate.of(2020, 2, 1));
        carValue1.setPriceEndOfLife(3000000);
        carValue2.setCarId(2L);
        carValue2.setGrossValue(5600000);
    }


    @Test
    void testFindAllCarValue() throws Exception {
        when(carValueService.getValuesList()).thenReturn(List.of(carValue1, carValue2));
        mockMvc.perform(get("/values"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].grossValue", equalTo(12000000)))
                .andExpect(jsonPath("$[0].priceEndOfLife", equalTo(3000000)))
                .andExpect(jsonPath("$[1].grossValue", equalTo(5600000)))
        ;
    }

    @Test
    void testListOfMonthlyDepreciation() throws Exception {
        Map<String, Integer> monthlyDepr = new HashMap<>();
        monthlyDepr.put("SUP-258", 75000);
        monthlyDepr.put("REW-951", 215000);

        when(carValueService.listOfMonthlyDepreciation()).thenReturn(monthlyDepr);
        mockMvc.perform(get("/values/depr"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    void testListOfCarsNetValue() throws Exception {
        Map<String, Integer> monthlyDepr = new HashMap<>();
        monthlyDepr.put("SUP-258", 5000000);
        monthlyDepr.put("REW-951", 3500000);

        when(carValueService.listOfCarsNetValue()).thenReturn(monthlyDepr);
        mockMvc.perform(get("/values/net_value"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}