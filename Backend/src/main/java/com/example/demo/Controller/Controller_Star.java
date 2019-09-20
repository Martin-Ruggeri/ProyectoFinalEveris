package com.example.demo.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DTO_Star;
import com.example.demo.Service.Service_Star;

@Controller
@RestController
@RequestMapping(path = "api/v1/star")
public class Controller_Star {

    static Logger log = Logger.getLogger(Controller_Star.class);
	
	private Service_Star service_Star;

	public Controller_Star(Service_Star service_Star) {
		log.debug("Se creo un Controller_Star");
		this.service_Star = service_Star;
	}
	
	@GetMapping(path="/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public DTO_Star getOne(@PathVariable int id) {
		log.debug("Controller_Star : getOne()");
		return ResponseEntity.status(200).body(service_Star.getOne(id)).getBody();
	}
	
	@GetMapping(path = "/")
	@CrossOrigin(origins = "*")
	@Transactional
	public List<DTO_Star> getAll(){
		log.debug("Controller_Star : getAll()");
		return ResponseEntity.status(200).body(service_Star.getAll()).getBody();
	}
	
	@PostMapping(path = "/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<DTO_Star> post(@RequestBody DTO_Star dTO_Star){
		DTO_Star resultDTO_Star = new DTO_Star();
		try {
			resultDTO_Star = service_Star.post(dTO_Star);
			log.debug("Controller_Star : post()");
		} catch (Exception e) {
			log.error("Error en Controller_Star : post()");
		}
		return ResponseEntity.status(201).body(resultDTO_Star);
	}
	
	@PutMapping(path = "/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<DTO_Star> put(@RequestBody DTO_Star dTO_Star, @PathVariable int id){
		DTO_Star resultDTO_Star = new DTO_Star();
		try {
			resultDTO_Star = service_Star.put(dTO_Star, id);
			log.debug("Controller_Star : put()");
		} catch (Exception e) {
			log.error("Error en Controller_Star : put()");
		}
			dTO_Star.setId(resultDTO_Star.getId());
			return ResponseEntity.status(201).body(dTO_Star);
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<String> delete(@PathVariable int id){
		boolean result = service_Star.delete(id);
		
		if(result) {
			log.debug("Controller_Star : delete()");
			return ResponseEntity.status(204).body("");
		}
		else {
			log.error("Error en Controller_Star : delete()");
			return ResponseEntity.status(204).body("No funciona");
		}
	}
}
