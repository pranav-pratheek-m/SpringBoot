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

import com.pranav.springprojects.models.VehicleStatus;
import com.pranav.springprojects.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehicleStatuses")
	public String getVehicleStatuss(Model model) {	
	    
	    List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuss();
	    model.addAttribute("vehicleStatusList",vehicleStatusList);
	    
		return "vehicleStatus";
	}
	
	@PostMapping("/vehicleStatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping("/vehicleStatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value="/vehicleStatuses/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus){
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping(value="/vehicleStatuses/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}


}
