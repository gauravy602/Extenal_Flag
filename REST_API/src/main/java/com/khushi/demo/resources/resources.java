package com.khushi.demo.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khushi.demo.Interface.service_Interface;
import com.khushi.demo.dao.AlienRepo;
import com.khushi.demo.model.Alien;


@Service
public class resources {
	@Value("${flag}")
	int flag;

	@Autowired
	AlienRepo repo;
	
	
	public String addProduct(Alien alien) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getAllAliens() {
		String s = repo.findAll().toString();
		System.out.println(s);
		return s;
	}


	public String delProduct(Integer aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Success";
	}
	

	
	
	
//	Map <Optional<Alien>,String> hm = new HashMap<Optional<Alien>,String>();
//	@GetMapping("/alien/{aid}")
//	public Map <Optional<Alien>,String> getAlien(@PathVariable("aid") Integer aid){
//		if(flag ==0) {
//			    hm.put(repo.findById(-1),"Access Denied");
//		}
//	     else{
//				hm.put(repo.findById(aid),"Success");
//		}
//		return hm;
//		}

	
	
}
