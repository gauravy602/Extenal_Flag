package com.khushi.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.khushi.demo.model.Alien;


public interface AlienRepo extends JpaRepository<Alien, Integer> {
	@Query(value ="select * from Alien a Where LENGTH(a.aname) >5", nativeQuery = true)
	List<Alien> getAlienByLength();
	
}