package com.pranav.springprojects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pranav.springprojects.models.User;
import com.pranav.springprojects.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
