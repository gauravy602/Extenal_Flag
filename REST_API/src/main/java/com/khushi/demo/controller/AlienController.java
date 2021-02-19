package com.khushi.demo.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.demo.dao.AlienRepo;
import com.khushi.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@PostMapping("/alien")
	public Alien home(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping("/aliens")
	public String getAliens() {
		return  repo.findAll().toString();
	}
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") Integer aid){
		return repo.findById(aid);}
	@DeleteMapping("/alien/{aid}")
	public String delAlien(@PathVariable("aid") Integer aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Success";
	}
	
	@PutMapping(path ="/alien/")
	public Alien put(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	
}