package com.codecool.vizsgaremek_v1.service;

import com.codecool.vizsgaremek_v1.entity.Depot;
import com.codecool.vizsgaremek_v1.entity.dto.DepotAddDto;
import com.codecool.vizsgaremek_v1.repository.DepotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotService {
    private final DepotRepository depotRepository;

    public DepotService(DepotRepository depotRepository) {
        this.depotRepository = depotRepository;
    }

    public List<Depot> findAll() {
        return depotRepository.findAll();
    }

    public Depot findById(long id) {
        return depotRepository.findById(id).orElse(null);
    }

    public Depot save(DepotAddDto depotAddDto) {
        Depot newDepot = new Depot();
        newDepot.setDepotName(depotAddDto.getDepotName());
        newDepot.setAddress(depotAddDto.getAddress());
        return depotRepository.save(newDepot);
    }

    public void deleteById(long id) {
        depotRepository.deleteById(id);
    }

}
