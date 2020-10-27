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
import com.pranav.springprojects.models.Client;
import com.pranav.springprojects.models.State;
import com.pranav.springprojects.services.CountryService;
import com.pranav.springprojects.services.ClientService;
import com.pranav.springprojects.services.StateService;

@Controller
public class ClientController {

	@Autowired 
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public String getClients(Model model) {	
	    List<State> stateList = stateService.getStates();
	    model.addAttribute("stateList",stateList);
	    
	    List<Country> countryList = countryService.getCountries();
	    model.addAttribute("countryList",countryList);
	    
	    List<Client> clientList = clientService.getClients();
	    model.addAttribute("clientList",clientList);
	    
		return "client";
	}
	
	@PostMapping("/clients/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("/clients/findById")
	@ResponseBody
	public Optional<Client> findById(int id){
		return clientService.findById(id);
	}
	
	@RequestMapping(value="/clients/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client){
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/clients/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		clientService.delete(id);
		return "redirect:/clients";
	}


}
