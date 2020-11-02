package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Employee;
import com.pranav.springprojects.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	public List<Employee> getEmployees(){
		return EmployeeRepository.findAll();
	}
	
	public void save(Employee Employee) {
		EmployeeRepository.save(Employee);
	}
	
	public Optional<Employee> findById(int id) {
		return EmployeeRepository.findById(id);
	}
	
	public void delete(int id) {
		EmployeeRepository.deleteById(id);
	}
}
