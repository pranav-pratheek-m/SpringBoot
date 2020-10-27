package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Country;
import com.pranav.springprojects.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	public List<String> getCountryNamesDistinct(){
		return countryRepository.findCountryNamesDistinct();
	}
	
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}
	
	public void delete(int id) {
		countryRepository.deleteById(id);
	}
}
