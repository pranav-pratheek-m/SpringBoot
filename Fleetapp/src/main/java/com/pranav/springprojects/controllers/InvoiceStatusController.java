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

import com.pranav.springprojects.models.InvoiceStatus;
import com.pranav.springprojects.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoiceStatuses")
	public String getInvoiceStatuss(Model model) {	
	    
	    List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
	    model.addAttribute("invoiceStatusList",invoiceStatusList);
	    
		return "invoiceStatus";
	}
	
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping("/invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){
		return invoiceStatusService.findById(id);
	}
	
	@RequestMapping(value="/invoiceStatuses/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus){
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping(value="/invoiceStatuses/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}


}
