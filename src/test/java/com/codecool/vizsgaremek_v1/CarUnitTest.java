package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.controller.CarController;
import com.codecool.vizsgaremek_v1.entity.Brand;
import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarUnitTest {

    @InjectMocks
    private CarController carController;

    @Mock
    private CarService carService;

    private final Car car1 = new Car();
    private final Car car2 = new Car();

    @BeforeEach
    public void init() {
        car1.setId(1L);
        car1.setRegistrationNumber("SUP-258");
        car1.setBrand(Brand.HONDA);
        car1.setModel("Civic");
        car1.setColor("orange");
        car1.setEngineNumber("asdfghjkl13546");
        car1.setPassengerCar(true);

        car2.setId(1L);
        car2.setRegistrationNumber("REW-951");
        car2.setBrand(Brand.VOLKSWAGEN);
        car2.setModel("Passat");
        car2.setColor("darkblue");
        car2.setEngineNumber("thisisenginenumber");
        car2.setPassengerCar(true);
    }

    @Test
    public void testFindAll(){
        when(carService.listCars()).thenReturn(List.of(car1, car2));
        List<Car> result = carController.listCars();
        assertEquals(result, carController.listCars());
        assertEquals(car1.getId(), result.get(0).getId());
        assertEquals(car1.getRegistrationNumber(), result.get(0).getRegistrationNumber());
    }
}
