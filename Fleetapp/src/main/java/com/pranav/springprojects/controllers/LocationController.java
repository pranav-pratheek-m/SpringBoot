package com.pranav.springprojects.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pranav.springprojects.models.Country;
import com.pranav.springprojects.models.Location;
import com.pranav.springprojects.models.State;
import com.pranav.springprojects.services.CountryService;
import com.pranav.springprojects.services.LocationService;
import com.pranav.springprojects.services.StateService;

@Controller
public class LocationController {

	
	@Autowired 
	private  StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	public String getLocations(Model model) {	
	    List<State> stateList = stateService.getStates();
	    model.addAttribute("stateList",stateList);
	    
	    List<Country> countryList = countryService.getCountries();
	    model.addAttribute("countryList",countryList);
	    
	    List<Location> locationList = locationService.getLocations();
	    model.addAttribute("locationList",locationList);
	    
		return "location";
	}
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id){
		return locationService.findById(id);
	}
	
	@RequestMapping(value="/locations/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location){
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		locationService.delete(id);
		return "redirect:/locations";
	}
}

