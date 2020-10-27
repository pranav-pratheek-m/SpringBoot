package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.VehicleType;
import com.pranav.springprojects.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	public List<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}
	
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}
	
	public void delete(int id) {
		vehicleTypeRepository.deleteById(id);
	}

}
