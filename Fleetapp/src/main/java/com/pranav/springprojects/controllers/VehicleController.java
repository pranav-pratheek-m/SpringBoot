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

import com.pranav.springprojects.models.Employee;
import com.pranav.springprojects.models.Location;
import com.pranav.springprojects.models.Vehicle;
import com.pranav.springprojects.models.VehicleMake;
import com.pranav.springprojects.models.VehicleModel;
import com.pranav.springprojects.models.VehicleStatus;
import com.pranav.springprojects.models.VehicleType;
import com.pranav.springprojects.services.EmployeeService;
import com.pranav.springprojects.services.LocationService;
import com.pranav.springprojects.services.VehicleMakeService;
import com.pranav.springprojects.services.VehicleModelService;
import com.pranav.springprojects.services.VehicleService;
import com.pranav.springprojects.services.VehicleStatusService;
import com.pranav.springprojects.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired
	private LocationService locationService;
	@Autowired 
	private  VehicleService vehicleService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleModelService vehicleModelService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehicles")
	public String getVehicles(Model model) {	
	    List<Vehicle> vehicleList = vehicleService.getVehicles();
	    model.addAttribute("vehicleList",vehicleList);
	    
	    List<Employee> employeeList = employeeService.getEmployees();
	    model.addAttribute("employeeList",employeeList);
	    
	    List<Location> locationList = locationService.getLocations();
	    model.addAttribute("locationList",locationList);
	    
	    List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
	    model.addAttribute("vehicleMakeList",vehicleMakeList);
	    
	    List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
	    model.addAttribute("vehicleModelList",vehicleModelList);
	    
	    List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
	    model.addAttribute("vehicleTypeList",vehicleTypeList);
	    
	    List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuss();
	    model.addAttribute("vehicleStatusList",vehicleStatusList);
		return "vehicle";
	}
	
	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping("/vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id){
		return vehicleService.findById(id);
	}
	
	@RequestMapping(value="/vehicles/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Vehicle vehicle){
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value="/vehicles/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}

}
