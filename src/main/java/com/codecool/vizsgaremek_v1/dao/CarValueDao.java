package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.entity.CarValue;

import java.util.List;
import java.util.Map;

public interface CarValueDao {

    List<CarValue> getValuesList();

    CarValue getValuesOfCar(long carId);

    void addNewValuesToACar(CarValue carValue);

    void updateValuesOfACar(CarValue carValue, long carId);

    void deleteValuesOfACar(long carId);

    Map<Long, Integer> listOfCarsNetValue();

    Map<Long, Integer> listOfMonthlyDepreciation();

}
