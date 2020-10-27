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

import com.pranav.springprojects.models.Client;
import com.pranav.springprojects.models.Invoice;
import com.pranav.springprojects.models.InvoiceStatus;
import com.pranav.springprojects.services.ClientService;
import com.pranav.springprojects.services.InvoiceService;
import com.pranav.springprojects.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoices")
	public String getInvoices(Model model) {	
	    
	    List<Client> clientList = clientService.getClients();
	    model.addAttribute("clientList",clientList);
	    
	    List<Invoice> invoiceList = invoiceService.getInvoices();
	    model.addAttribute("invoiceList",invoiceList);
	    
	    List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
	    model.addAttribute("invoiceStatusList",invoiceStatusList);
	    
		return "invoice";
	}
	
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id){
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value="/invoices/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Invoice invoice){
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="/invoices/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id){
		invoiceService.delete(id);
		return "redirect:/invoices";
	}


}
