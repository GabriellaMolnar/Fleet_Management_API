package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.dto.CarAddUpdateDto;
import com.codecool.vizsgaremek_v1.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    void addUpdateDeleteCarTest() {
        int sizeBeforeAdd = carService.listCars().size();
        CarAddUpdateDto newCar = new CarAddUpdateDto("SSS-666", Brand.MINI, "Cooper", "white",
                "645d344dsadsfafd", true);
        Car addedCar = carService.addCar(newCar);
        assertEquals(sizeBeforeAdd + 1, carService.listCars().size());

        long id = addedCar.getId();
        CarAddUpdateDto updateCar = new CarAddUpdateDto("SSS-666", Brand.MINI, "Cooper", "black",
                "645d344dsadsfafd", true);

        assertEquals("black", carService.updateCar(updateCar, id).getColor());

    }

}
