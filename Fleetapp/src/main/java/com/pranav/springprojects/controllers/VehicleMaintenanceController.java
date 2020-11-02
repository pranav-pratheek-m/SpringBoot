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

import com.pranav.springprojects.models.Supplier;
import com.pranav.springprojects.models.Vehicle;
import com.pranav.springprojects.models.VehicleMaintenance;
import com.pranav.springprojects.services.SupplierService;
import com.pranav.springprojects.services.VehicleMaintenanceService;
import com.pranav.springprojects.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/vehicleMaintenances")
	public String getVehicleMaintenances(Model model) {	
	    
	    List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
	    model.addAttribute("vehicleMaintenanceList",vehicleMaintenanceList);
	    
	    List<Vehicle> vehicleList = vehicleService.getVehicles();
	    model.addAttribute("vehicleList",vehicleList);
	    
	    List<Supplier> supplierList = supplierService.getSuppliers();
	    model.addAttribute("supplierList",supplierList);
	    
		return "vehicleMaintenance";
	}
	
	@PostMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping("/vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id){
		return vehicleMaintenanceService.findById(id);
	}
	
	@RequestMapping(value="/vehicleMaintenances/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance){
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping(value="/vehicleMaintenances/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}


}
