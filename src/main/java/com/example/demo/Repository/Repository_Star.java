package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Star;

@Repository
public interface Repository_Star extends JpaRepository<Star, Integer> {
	
}
