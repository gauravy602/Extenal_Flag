package com.khushi.demo.controller;

import java.util.HashMap;
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

@PropertySource("info.properties")

@RestController
public class AlienController {
	@Value("${flag}")
	int flag;
	
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
	Map <Optional<Alien>,String> hm = new HashMap<Optional<Alien>,String>();
	@GetMapping("/alien/{aid}")
	public Map <Optional<Alien>,String> getAlien(@PathVariable("aid") Integer aid){
		if(flag ==0) {
			    hm.put(repo.findById(-1),"Access Denied");
		}
	     else{
				hm.put(repo.findById(aid),"Success");
		}
		return hm;
		}
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