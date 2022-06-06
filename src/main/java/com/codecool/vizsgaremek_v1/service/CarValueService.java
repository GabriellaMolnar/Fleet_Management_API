package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.CarValue;
import com.codecool.vizsgaremek_v1.repository.CarValueRepository;
import org.springframework.stereotype.Service;

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
        if (carValueToUpdate!=null) {
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

    public Map<Long, Integer> listOfCarsNetValue() {
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
