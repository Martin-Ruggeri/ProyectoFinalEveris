package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTO_Planet;
import com.example.demo.DTO.DTO_Star;
import com.example.demo.Entity.Planet;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.Repository_Planet;

@Service
public class Service_Planet {

    static Logger log = Logger.getLogger(Service_Planet.class);
	
	private Repository_Planet repository_Planet;
	
	public Service_Planet(Repository_Planet repository_Planet) {
		log.debug("Se creo un Service_Planet");
		this.repository_Planet = repository_Planet;
	}
	


	@Transactional
	public DTO_Planet getOne(int id) {	
		Optional<Planet> bd = repository_Planet.findById(id);
		DTO_Planet dTO_Planet = new DTO_Planet();
		DTO_Star dTO_Star = new DTO_Star();
		try {
			Planet planet = bd.get();
			dTO_Planet.setId(planet.getId());
			dTO_Planet.setSize(planet.getSize());
			dTO_Planet.setName(planet.getName());
			
			dTO_Planet.setdTO_Star(dTO_Star);
			dTO_Planet.getdTO_Star().setId(planet.getStar().getId());
			dTO_Planet.getdTO_Star().setDensity(planet.getStar().getDensity());
			dTO_Planet.getdTO_Star().setName(planet.getStar().getName());
			log.debug("Service_Planet : getOne()");
			return dTO_Planet;
		} catch (Exception e) {	
			log.error("Error en Service_Planet : getOne()");
			return dTO_Planet;
		}
	}
	
	@Transactional
	public List<DTO_Planet> getAll(){	
		List<DTO_Planet> lista = new ArrayList<>();	
		try {
			for (Planet planet : repository_Planet.findAll()) {
				// cargo de la entidad al Dto
				DTO_Planet dTO_Planet = new DTO_Planet();
				dTO_Planet.setId(planet.getId());
				dTO_Planet.setSize(planet.getSize());
				dTO_Planet.setName(planet.getName());
				
				DTO_Star dTO_Star = new DTO_Star();
				dTO_Planet.setdTO_Star(dTO_Star);
				dTO_Planet.getdTO_Star().setId(planet.getStar().getId());
				dTO_Planet.getdTO_Star().setDensity(planet.getStar().getDensity());
				dTO_Planet.getdTO_Star().setName(planet.getStar().getName());
//				Cargo a cada elemento el dto
				lista.add(dTO_Planet);
			}
			log.debug("Service_Planet : getAll()");
		} catch (Exception e) {
			log.error("Error en Service_Planet : getAll()");
		}
		
		return lista;
		
	}
	
	@Transactional
	public DTO_Planet post(DTO_Planet dTO_Planet) {		
		try {			
			Planet planet = new Planet();		
			planet.setSize(dTO_Planet.getSize());
			planet.setName(dTO_Planet.getName());
			
			Star star = new Star();
			star.setId(dTO_Planet.getdTO_Star().getId());
			
			planet.setStar(star);
			
			planet = repository_Planet.save(planet);
			
			dTO_Planet.setId(planet.getId());
			log.debug("Service_Planet : post()");
		} catch (Exception e) {					
			log.error("Error en Service_Planet : post()");
			System.out.println(e.getMessage());
		}	
		return dTO_Planet;
		
	}
	
	@Transactional
	public DTO_Planet put(DTO_Planet dTO_Planet, int id) {
		Optional<Planet> temp = repository_Planet.findById(id);			
		
		try {		
			Planet planet = temp.get();
			planet.setName(dTO_Planet.getName());
			planet.setSize(dTO_Planet.getSize());
			
			Star star = new Star();
		    star.setId(dTO_Planet.getdTO_Star().getId());
			star.setDensity(dTO_Planet.getdTO_Star().getDensity());
			star.setName(dTO_Planet.getdTO_Star().getName());
			
			planet.setStar(star);
			
			repository_Planet.save(planet);		
			dTO_Planet.setId(planet.getId());	
			log.debug("Service_Planet : put()");
		} catch (Exception e) {
			log.error("Error en Service_Planet : put()");
		}			
		return dTO_Planet;	
	}
	
	@Transactional
	public boolean delete(int id) {
		Optional<Planet> planet = repository_Planet.findById(id);	
		try {					
			repository_Planet.delete(planet.get());
			log.debug("Service_Planet : delete()");
			return true;		
		} catch (Exception e) {
			log.error("Error en Service_Planet : delete()");
			return false;
		}
		
	}
	
}
