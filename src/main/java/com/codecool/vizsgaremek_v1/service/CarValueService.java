package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.dao.CarValueDao;
import com.codecool.vizsgaremek_v1.model.CarValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarValueService {
    private CarValueDao carValueDao;

    @Autowired
    public CarValueService(@Qualifier("carValueMemDao") CarValueDao carValueDao) {
        this.carValueDao = carValueDao;
    }

    public List<CarValue> getValuesList() {
        return carValueDao.getValuesList();
    }

    public CarValue getValuesOfCar(long carId) {
        return carValueDao.getValuesOfCar(carId);
    }

    public void addNewValuesToACar(CarValue carValue) {
        carValueDao.addNewValuesToACar(carValue);
    }

    public void updateValuesOfACar(CarValue carValue, long carId) {
        carValueDao.updateValuesOfACar(carValue, carId);
    }

    public void deleteValuesOfACar(long carId) {
        carValueDao.deleteValuesOfACar(carId);
    }

    public Map<Long, Integer> listOfCarsNetValue() {
        return carValueDao.listOfCarsNetValue();
    }

    public Map<Long, Integer> listOfMonthlyDepreciation() {
        return carValueDao.listOfMonthlyDepreciation();
    }
}
