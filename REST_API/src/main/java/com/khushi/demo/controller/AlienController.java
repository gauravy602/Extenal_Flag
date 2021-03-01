package com.khushi.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.demo.dao.AlienRepo;
import com.khushi.demo.model.Alien;
import com.khushi.demo.resources.resources;

@PropertySource("info.properties")
@RestController
public class AlienController {
	@Value("${flag}")
	int flag;
	
	@Autowired
	private AlienRepo repo;
	
	@Autowired
	private resources r;
	
	
	
	@PostMapping("/alien")
	public String addProduct(Alien alien) {
		return r.addProduct(alien);
	}
	
	@GetMapping("/aliens")
	public String getProduct() {
		return r.getAllAliens();
	}
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") Integer aid){
		return repo.findById(aid);
	}
	

	@DeleteMapping("/alien/{aid}")
	public String delAlien(@PathVariable("aid") Integer aid) {
		return r.delProduct(aid);
	}
	
	@GetMapping("alien/smallname")
	public List<Alien> smallName() {
	return repo.getAlienByLength();	
	}
	
	
}