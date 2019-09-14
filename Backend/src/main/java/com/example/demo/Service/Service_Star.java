package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTO_Star;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.Repository_Star;

@Service
public class Service_Star {
	
	private Repository_Star repository_Star;

	public Service_Star(Repository_Star repository_Star) {
		this.repository_Star = repository_Star;
	}
	
	public DTO_Star getOne(int id){
		Optional<Star> bd = repository_Star.findById(id);
		DTO_Star dTO_Star = new DTO_Star();
		
		try {
			Star star = bd.get();
			dTO_Star.setName(star.getName());
			dTO_Star.setDensity(star.getDensity());
			dTO_Star.setId(star.getId());
			
			return dTO_Star;
		} catch (Exception e) {
			return dTO_Star;
		}
	}
	
	public List<DTO_Star> getAll(){
		List<DTO_Star> lista = new ArrayList<>();
		try {
			for (Star star : repository_Star.findAll()) {
				DTO_Star dTO_Star = new DTO_Star();
				dTO_Star.setDensity(star.getDensity());
				dTO_Star.setName(star.getName());
				dTO_Star.setId(star.getId());
				
				lista.add(dTO_Star);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	public DTO_Star post(DTO_Star dTO_Star) {
		
		try {
			Star star = new Star();
			star.setId(dTO_Star.getId());
			star.setDensity(dTO_Star.getDensity());
			star.setName(dTO_Star.getName());
			repository_Star.save(star);
			dTO_Star.setId(star.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dTO_Star;
	}
	
	public DTO_Star put(DTO_Star dTO_Star, int id) {
		Optional<Star> bd = repository_Star.findById(id);
		
		try {
			Star star = bd.get();
			star.setId(dTO_Star.getId());
			star.setDensity(dTO_Star.getDensity());
			star.setName(dTO_Star.getName());
			repository_Star.save(star);
			dTO_Star.setId(star.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dTO_Star;
		
	}
	
	public boolean delete(int id){
		Optional<Star> bd = repository_Star.findById(id);
		try {
			repository_Star.delete(bd.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
