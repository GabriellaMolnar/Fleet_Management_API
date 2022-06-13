package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.Car;
import com.codecool.vizsgaremek_v1.entity.CarValue;
import com.codecool.vizsgaremek_v1.entity.dto.CarValueAddUpdateDto;
import com.codecool.vizsgaremek_v1.repository.CarRepository;
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
    private final CarRepository carRepository;

    public CarValueService(CarValueRepository carValueRepository, CarRepository carRepository) {
        this.carValueRepository = carValueRepository;
        this.carRepository = carRepository;
    }

    public List<CarValue> getValuesList() {
        List<CarValue> carValueList = carValueRepository.findAll();
        setNetValuesForAllCars(carValueList);
        return carValueList;
    }

    public CarValue getValuesOfCar(long carId) {
        CarValue carValue = carValueRepository.findCarValueByCarId(carId);
        setNetValueById(carValue.getCarId());
        return carValue;
    }

    public void addNewValuesToACar(CarValueAddUpdateDto carValueAddUpdateDto) {
        CarValue newCarValue = new CarValue();
        newCarValue.setCarId(carValueAddUpdateDto.getCarId());
        newCarValue.setEntryDate(carValueAddUpdateDto.getEntryDate());
        newCarValue.setGrossValue(carValueAddUpdateDto.getGrossValue());
        newCarValue.setPlannedEndOfLife(carValueAddUpdateDto.getPlannedEndOfLife());
        newCarValue.setPriceEndOfLife(carValueAddUpdateDto.getPriceEndOfLife());
        carValueRepository.save(newCarValue);
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

    private void setMonthlyDepreciationForAllCars(List<CarValue> carValueList) {
        for (CarValue carValue : carValueList) {
            setMonthlyDeprByCarId(carValue.getCarId());
        }
    }

    private void setMonthlyDeprByCarId(long carId) {
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
        thisCarValue.setMonthlyDepr(monthlyDepr);
    }

    public void setNetValuesForAllCars(List<CarValue> carValueList) {
        for (CarValue carValue : carValueList) {
            setNetValueById(carValue.getCarId());
        }
    }

    private void setNetValueById(long carId) {
        int netValue;
        CarValue thisCarValue = carValueRepository.getById(carId);
        LocalDate entryDate = thisCarValue.getEntryDate();
        int numberOfMonthsPassed = (int) ChronoUnit.MONTHS.between(
                YearMonth.from(entryDate),
                YearMonth.from(YearMonth.now())
        );
        setMonthlyDeprByCarId(carId);
        // int monthlyDepr = getMonthlyDepr(carId);
        int totalDepr = thisCarValue.getMonthlyDepr() * numberOfMonthsPassed;
        netValue = thisCarValue.getGrossValue() - totalDepr;
        thisCarValue.setNetValue(netValue);
    }

    public Map<String, Integer> listOfCarsNetValue() {
        Map<String, Integer> netValues = new HashMap<>();
        List<CarValue> carValueList = carValueRepository.findAll();
        setNetValuesForAllCars(carValueList);
        for (CarValue carValue : carValueList) {
            Car car = carRepository.findById(carValue.getCarId()).orElse(null);
            netValues.put(car.getRegistrationNumber(), carValue.getNetValue());
        }
        return netValues;
    }

    public Map<String, Integer> listOfMonthlyDepreciation() {
        Map<String, Integer> monthlyDepr = new HashMap<>();
        List<CarValue> carValueList = carValueRepository.findAll();
        setMonthlyDepreciationForAllCars(carValueList);
        for (CarValue carValue : carValueList) {
            Car car = carRepository.findById(carValue.getCarId()).orElse(null);
            monthlyDepr.put(car.getRegistrationNumber(), carValue.getMonthlyDepr());
        }
        return monthlyDepr;
    }
}
