package com.md.car.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.car.parameters.models.Location;
import com.md.car.parameters.repositories.LocationRepository;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public Location findById(Integer id) {
		return locationRepository.findById(id).orElse(null);
	}

	public void save(Location location) {
		locationRepository.save(location);
	}

	public void deleteById(Integer id) {
		locationRepository.deleteById(id);
	}

	public List<Location> findByDescriptionContaining(String description) {
		return null;
	}
}
