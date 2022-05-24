package com.codecool.vizsgaremek_v1.dao;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("carValueMemDao")
public class CarValueMemDao implements CarValueDao {

    private List<CarValue> carValueList = new ArrayList<>();

    @Override
    public List<CarValue> getValuesList() {
        return carValueList;
    }

    @Override
    public CarValue getValuesOfCar(long carId) {
        return carValueList.stream().filter(e -> e.getCarId() == carId).findFirst().get();
    }

    @Override
    public void addNewValuesToACar(CarValue carValue) {
        carValueList.add(carValue);
    }

    @Override
    public void updateValuesOfACar(CarValue carValue, long carId) {
        CarValue carValueToMod = getValuesOfCar(carId);
        carValueToMod.setGrossValue(carValue.getGrossValue());
        carValueToMod.setEntryDate(carValue.getEntryDate());
        carValueToMod.setPlannedEndOfLife(carValue.getPlannedEndOfLife());
        carValueToMod.setPriceEndOfLife(carValue.getPriceEndOfLife());
        //TODO
    }

    @Override
    public void deleteValuesOfACar(long carId) {
        carValueList.removeIf(e -> e.getCarId() == carId);
    }

    @Override
    public Map<Long, Integer> listOfCarsNetValue() {
        //TODO
        return null;
    }

    @Override
    public Map<Long, Integer> listOfMonthlyDepreciation() {
        //TODO
        return null;
    }
}
