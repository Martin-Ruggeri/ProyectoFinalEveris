package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTO_Star;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.Repository_Star;

@Service
public class Service_Star {
	
    static Logger log = Logger.getLogger(Service_Star.class);
	
	private Repository_Star repository_Star;

	public Service_Star(Repository_Star repository_Star) {
		log.debug("Se creo un Service_Star");
		this.repository_Star = repository_Star;
	}
	
	@Transactional
	public DTO_Star getOne(int id){
		Optional<Star> bd = repository_Star.findById(id);
		DTO_Star dTO_Star = new DTO_Star();
		
		try {
			Star star = bd.get();
			dTO_Star.setName(star.getName());
			dTO_Star.setDensity(star.getDensity());
			dTO_Star.setId(star.getId());
			
			log.debug("Service_Star : getOne()");
			return dTO_Star;
		} catch (Exception e) {
			log.error("Error en Service_Star: getOne()");
			return dTO_Star;
		}
	}
	
	@Transactional
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
			log.debug("Service_Star : getAll()");
		} catch (Exception e) {
			log.error("Error en Service_Star: getAll()");
		}
		return lista;
	}
	
	@Transactional
	public DTO_Star post(DTO_Star dTO_Star) {
		
		try {
			Star star = new Star();
			star.setDensity(dTO_Star.getDensity());
			star.setName(dTO_Star.getName());
			repository_Star.save(star);
			dTO_Star.setId(star.getId());
			log.debug("Service_Star : post()");
		} catch (Exception e) {
			log.error("Error en Service_Star: post()");
		}
		return dTO_Star;
	}
	
	@Transactional
	public DTO_Star put(DTO_Star dTO_Star, int id) {
		Optional<Star> bd = repository_Star.findById(id);
		
		try {
			Star star = bd.get();
			star.setDensity(dTO_Star.getDensity());
			star.setName(dTO_Star.getName());
			repository_Star.save(star);
			dTO_Star.setId(star.getId());
			log.debug("Service_Star : put()");
		} catch (Exception e) {
			log.error("Error en Service_Star: put()");
		}
		return dTO_Star;
		
	}
	
	@Transactional
	public boolean delete(int id){
		Optional<Star> bd = repository_Star.findById(id);
		try {
			repository_Star.delete(bd.get());
			log.debug("Service_Star : delete()");
			return true;
		} catch (Exception e) {
			log.error("Error en Service_Star: delete()");
			return false;
		}
	}
}
