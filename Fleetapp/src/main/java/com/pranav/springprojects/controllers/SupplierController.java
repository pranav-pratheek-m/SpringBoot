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
import com.pranav.springprojects.models.Supplier;
import com.pranav.springprojects.models.State;
import com.pranav.springprojects.services.CountryService;
import com.pranav.springprojects.services.SupplierService;
import com.pranav.springprojects.services.StateService;

@Controller
public class SupplierController {

	@Autowired 
	private  StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {	
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
	    
	    List<Supplier> supplierList = supplierService.getSuppliers();
	    model.addAttribute("supplierList",supplierList);
	    
		return "supplier";
	}
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("/suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id){
		return supplierService.findById(id);
	}
	
	@RequestMapping(value="/suppliers/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier){
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/suppliers/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		supplierService.delete(id);
		return "redirect:/suppliers";
	}

}
