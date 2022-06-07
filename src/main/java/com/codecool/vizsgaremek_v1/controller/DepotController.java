package com.codecool.vizsgaremek_v1.controller;

import com.codecool.vizsgaremek_v1.entity.Depot;
import com.codecool.vizsgaremek_v1.entity.dto.DepotAddDto;
import com.codecool.vizsgaremek_v1.service.DepotService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depots")
public class DepotController {
    private final DepotService depotService;

    public DepotController(DepotService depotService) {
        this.depotService = depotService;
    }

    @GetMapping
    @Operation(summary = "Get depots",
            description = "Get list of depots")
    public List<Depot> findAll() {
        return depotService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a depot",
            description = "Get a depot by id")
    public Depot findById(@PathVariable Long id) {
        return depotService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Add a depot",
            description = "Add an new depot to your depot list")
    public Depot save(@RequestBody DepotAddDto depot) {
        return depotService.save(depot);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a depot",
            description = "Delete a depot from your depot list")
    public void delete(@PathVariable Long id) {
        depotService.deleteById(id);
    }
}
