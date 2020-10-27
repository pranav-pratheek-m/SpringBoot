package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Location;
import com.pranav.springprojects.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}
	
	public void delete(int id) {
		locationRepository.deleteById(id);
	}
}
