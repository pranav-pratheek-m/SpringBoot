package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Vehicle;
import com.pranav.springprojects.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository VehicleRepository;
	
	public List<Vehicle> getVehicles(){
		return VehicleRepository.findAll();
	}
	
	public void save(Vehicle Vehicle) {
		VehicleRepository.save(Vehicle);
	}
	
	public Optional<Vehicle> findById(int id) {
		return VehicleRepository.findById(id);
	}
	
	public void delete(int id) {
		VehicleRepository.deleteById(id);
	}
}
