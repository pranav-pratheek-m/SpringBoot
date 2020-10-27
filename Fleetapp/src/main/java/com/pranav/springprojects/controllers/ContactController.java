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

import com.pranav.springprojects.models.Contact;
import com.pranav.springprojects.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String getContacts(Model model) {	
	    
	    List<Contact> contactList = contactService.getContacts();
	    model.addAttribute("contactList",contactList);
	    
		return "contact";
	}
	
	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("/contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id){
		return contactService.findById(id);
	}
	
	@RequestMapping(value="/contacts/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact){
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		contactService.delete(id);
		return "redirect:/contacts";
	}


}
