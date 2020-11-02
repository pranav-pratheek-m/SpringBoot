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
import com.pranav.springprojects.models.Employee;
import com.pranav.springprojects.models.EmployeeType;
import com.pranav.springprojects.models.JobTitle;
import com.pranav.springprojects.models.State;
import com.pranav.springprojects.services.CountryService;
import com.pranav.springprojects.services.EmployeeService;
import com.pranav.springprojects.services.EmployeeTypeService;
import com.pranav.springprojects.services.JobTitleService;
import com.pranav.springprojects.services.StateService;

@Controller
public class EmployeeController {

	@Autowired 
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {	
	    List<State> stateList = stateService.getStates();
	    model.addAttribute("stateList",stateList);
	    
	    List<Country> countryList = countryService.getCountries();
	    model.addAttribute("countryList",countryList);
	    
	    List<Employee> employeeList = employeeService.getEmployees();
	    model.addAttribute("employeeList",employeeList);
	    
	    List<JobTitle> jobTitlesList = jobTitleService.getJobTitles();
	    model.addAttribute("jobTitlesList",jobTitlesList);
	    
	    List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
	    model.addAttribute("employeeTypeList",employeeTypeList);
	    
		return "employee";
	}
	
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("/employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id){
		return employeeService.findById(id);
	}
	
	@RequestMapping(value="/employees/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Employee employee){
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employees/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		employeeService.delete(id);
		return "redirect:/employees";
	}


}
