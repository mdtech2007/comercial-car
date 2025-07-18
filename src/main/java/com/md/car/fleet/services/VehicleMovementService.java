package com.md.car.fleet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.car.fleet.models.VehicleMovement;
import com.md.car.fleet.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//Get All VehicleMovements
	public List<VehicleMovement> findAll(){
		return vehicleMovementRepository.findAll();
	}	
	
	//Get VehicleMovement By Id
	public VehicleMovement findById(int id) {
		return vehicleMovementRepository.findById(id).orElse(null);
	}	
	
	//Delete VehicleMovement
	public void delete(int id) {
		vehicleMovementRepository.deleteById(id);
	}
	
	//Update VehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}

}
