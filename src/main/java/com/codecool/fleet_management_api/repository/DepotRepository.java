package com.codecool.fleet_management_api.repository;

import com.codecool.fleet_management_api.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepotRepository extends JpaRepository<Depot, Long> {
}
