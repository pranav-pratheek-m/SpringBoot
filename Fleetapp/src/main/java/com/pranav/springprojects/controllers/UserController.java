package com.pranav.springprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.pranav.springprojects.models.User;
import com.pranav.springprojects.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String getUsers() {
		return "user";
	}
	
	@PostMapping(value="/users/addNew")
	public RedirectView addNew(User user,RedirectAttributes redir ) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login",true);
		redir.addFlashAttribute("message", "Successfully registered!!You can login now..");
		return redirectView;
	}
}
