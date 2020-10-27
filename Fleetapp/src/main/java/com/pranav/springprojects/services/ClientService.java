package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.Client;
import com.pranav.springprojects.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}
	
	public void delete(int id) {
		clientRepository.deleteById(id);
	}

}
