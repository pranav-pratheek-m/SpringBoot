package com.pranav.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pranav.demo.dao.AlienRepo;
import com.pranav.demo.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo alienrepo;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping(path="/alien",consumes="application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		alienrepo.save(alien);
		return alien;
	}
	
	@PutMapping(path="/alien",consumes="application/json")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		alienrepo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid) {
		
		Alien alien = alienrepo.getOne(aid);
		alienrepo.delete(alien);
		return "deleted";
	}
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("ShowAlien.jsp");
//		Alien alien = alienrepo.findById(aid).orElse(new Alien());
//		System.out.println("Java associates: " + alienrepo.findByTech("Java"));
//		System.out.println("Aid > 102: " + alienrepo.findByAidGreaterThan(102));
//		System.out.println("Aid < 106: " + alienrepo.findByAidLessThan(106));
//		System.out.println("Java associates with sorted names: " + alienrepo.findByTechSortedName("Java"));
//		mv.addObject(alien);
//		return mv;
//	}
	
	//,produces="application/xml"
	@GetMapping(path="/aliens")
	//@ResponseBody
	public List<Alien> getAliens() {
	
		return alienrepo.findAll();
	}
	
	//,produces="application/xml"
	@GetMapping(path="/alien/{aid}")
	//@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
	
		return alienrepo.findById(aid);
	}
}

