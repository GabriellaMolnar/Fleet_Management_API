package com.codecool.vizsgaremek_v1;

import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.service.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceUnitTest {
    @Autowired
    private CarService carService;

    @Test
    public void CarListTest(){
        List<Car> cars = carService.listCars();
        Assert.assertEquals(cars.size(), 2);
        Assert.assertEquals(cars.get(0).getColor(), "blue" );
    }


}
