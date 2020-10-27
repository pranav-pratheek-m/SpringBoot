package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Invoice;
import com.pranav.springprojects.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}
	
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}
	
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
}
