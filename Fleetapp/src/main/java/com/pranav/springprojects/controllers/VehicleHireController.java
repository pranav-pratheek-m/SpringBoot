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

import com.pranav.springprojects.models.VehicleHire;
import com.pranav.springprojects.services.VehicleHireService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	
	@GetMapping("/vehicleHires")
	public String getVehicleHires(Model model) {	
	    
	    List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
	    model.addAttribute("vehicleHireList",vehicleHireList);
	    
		return "vehicleHire";
	}
	
	@PostMapping("/vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping("/vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id){
		return vehicleHireService.findById(id);
	}
	
	@RequestMapping(value="/vehicleHires/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleHire vehicleHire){
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping(value="/vehicleHires/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	}


}
