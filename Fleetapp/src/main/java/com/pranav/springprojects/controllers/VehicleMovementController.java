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

import com.pranav.springprojects.models.Location;
import com.pranav.springprojects.models.Vehicle;
import com.pranav.springprojects.models.VehicleMovement;
import com.pranav.springprojects.services.LocationService;
import com.pranav.springprojects.services.VehicleMovementService;
import com.pranav.springprojects.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/vehicleMovements")
	public String getVehicleMovements(Model model) {	
	    List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
	    model.addAttribute("vehicleMovementList",vehicleMovementList);
	    
	    List<Vehicle> vehicleList = vehicleService.getVehicles();
	    model.addAttribute("VehicleList",vehicleList);
	    
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locationList", locationList);
	    
		return "vehicleMovement";
	}
	
	@PostMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping("/vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id){
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value="/vehicleMovements/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement){
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value="/vehicleMovements/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}


}
