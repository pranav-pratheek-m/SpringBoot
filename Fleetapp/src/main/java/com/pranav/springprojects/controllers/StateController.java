package com.pranav.springprojects.controllers;

import java.util.ArrayList;
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
import com.pranav.springprojects.models.State;
import com.pranav.springprojects.services.CountryService;
import com.pranav.springprojects.services.StateService;

@Controller
public class StateController {
	
	@Autowired 
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model model) {	
	    List<State> stateList = stateService.getStates();
	    model.addAttribute("stateList",stateList);
	    
	    List<Country> totalCountryList = countryService.getCountries();
	    List<String> distinctCountryNames = new ArrayList<>();
	    List<Country> countryList = new ArrayList<>();
	    
	    for(Country country :totalCountryList) {
	    	if(!distinctCountryNames.contains(country.getDescription())) {
	    		distinctCountryNames.add(country.getDescription());
	    		countryList.add(country);
	    	}
	    }
	    model.addAttribute("countryList",countryList);
		return "state";
	}
	
	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	@RequestMapping("/states/findById")
	@ResponseBody
	public Optional<State> findById(int id){
		return stateService.findById(id);
	}
	
	@RequestMapping(value="/states/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(State state){
		stateService.save(state);
		return "redirect:/states";
	}
	
	@RequestMapping(value="/states/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		stateService.delete(id);
		return "redirect:/states";
	}

}
