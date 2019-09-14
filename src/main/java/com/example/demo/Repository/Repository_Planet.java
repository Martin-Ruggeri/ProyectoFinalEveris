package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Planet;

@Repository
public interface Repository_Planet extends JpaRepository<Planet, Integer>{
	
}
