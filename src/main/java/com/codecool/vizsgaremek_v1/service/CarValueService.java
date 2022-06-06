package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import com.codecool.vizsgaremek_v1.repository.CarValueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarValueService {
    private final CarValueRepository carValueRepository;

    public CarValueService(CarValueRepository carValueRepository) {
        this.carValueRepository = carValueRepository;
    }

    public List<CarValue> getValuesList() {
        return carValueRepository.findAll();
    }

    public CarValue getValuesOfCar(long carId) {
        return carValueRepository.getById(carId);
    }

    public void addNewValuesToACar(CarValue carValue) {
        carValueRepository.save(carValue);
    }

    public void updateValuesOfACar(CarValue carValue, long carId) {
        CarValue carValueToUpdate = carValueRepository.findById(carId).orElse(null);
        if (carValueToUpdate != null) {
            carValueToUpdate.setEntryDate(carValue.getEntryDate());
            carValueToUpdate.setGrossValue(carValue.getGrossValue());
            carValueToUpdate.setPlannedEndOfLife(carValue.getPlannedEndOfLife());
            carValueToUpdate.setPriceEndOfLife(carValue.getPriceEndOfLife());
        }
        carValueRepository.save(carValueToUpdate);
    }

    public void deleteValuesOfACar(long carId) {
        carValueRepository.deleteById(carId);
    }

    public void setMonthlyDepreciation() {
        List<CarValue> carValueList = carValueRepository.findAll();
        for (CarValue carValue : carValueList) {
            carValue.setMonthlyDepr(getMonthlyDepr(carValue.getCarId()));
            updateValuesOfACar(carValue, carValue.getCarId());
        }
    }

    private int getMonthlyDepr(long carId) {
        int monthlyDepr;
        CarValue thisCarValue = carValueRepository.getById(carId);
        LocalDate entryDate = thisCarValue.getEntryDate();
        LocalDate plannedEndOfLife = thisCarValue.getPlannedEndOfLife();
        int monthsCount = (int) ChronoUnit.MONTHS.between(
                YearMonth.from(entryDate),
                YearMonth.from(plannedEndOfLife)
        );
        int priceToDepr = thisCarValue.getGrossValue() - thisCarValue.getPriceEndOfLife();
        monthlyDepr = priceToDepr / monthsCount;
        return monthlyDepr;
    }

    public void setNetValues() {
        List<CarValue> carValueList = carValueRepository.findAll();
        for (CarValue carValue : carValueList) {
            carValue.setNetValue(getNetValue(carValue.getCarId()));
            updateValuesOfACar(carValue, carValue.getCarId());
        }
    }

    private int getNetValue(long carId) {
        int netValue = 0;
        CarValue thisCarValue = carValueRepository.getById(carId);
        LocalDate entryDate = thisCarValue.getEntryDate();
        int numberOfMonthsPassed = (int) ChronoUnit.MONTHS.between(
                YearMonth.from(entryDate),
                YearMonth.from(YearMonth.now())
        );
        int monthlyDepr = getMonthlyDepr(carId);
        int totalDepr = monthlyDepr * numberOfMonthsPassed;

        netValue = thisCarValue.getGrossValue() - totalDepr;
        return netValue;
    }

    public Map<Long, Integer> listOfCarsNetValue() {
        Map<Long, Integer> netValues = new HashMap<>();
        //  return carValueRepository.listOfCarsNetValue();
        //TODO
        return null;
    }

    public Map<Long, Integer> listOfMonthlyDepreciation() {
        //  return carValueRepository.listOfMonthlyDepreciation();
        //TODO
        return null;
    }
}
