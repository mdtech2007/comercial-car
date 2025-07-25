package com.md.car.fleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.md.car.fleet.models.VehicleHire;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}
