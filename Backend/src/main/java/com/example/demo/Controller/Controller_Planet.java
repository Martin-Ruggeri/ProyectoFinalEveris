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

import com.example.demo.DTO.DTO_Planet;
import com.example.demo.Service.Service_Planet;

@Controller
@RestController
@RequestMapping(path = "api/v1/planet")
public class Controller_Planet {

    static Logger log = Logger.getLogger(Controller_Planet.class);
    
	private Service_Planet service_Planet;
	
	public Controller_Planet(Service_Planet service_Planet) {
		log.debug("Se creo un Controller_Planet");
		this.service_Planet = service_Planet;
	}

	//localhost:9000/api/v1/planet/{id}
	@GetMapping(path="/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public DTO_Planet getOne(@PathVariable int id) {
		log.debug("Controller_Planet : getOne()");
		return ResponseEntity.status(200).body(service_Planet.getOne(id)).getBody();
	}
	
	//localhost:9000/api/v1/planet/
	@GetMapping(path="/")
	@CrossOrigin(origins = "*")
	@Transactional
	public List<DTO_Planet> getAll() {
		log.debug("Controller_Planet : getAll()");
		return ResponseEntity.status(200).body(service_Planet.getAll()).getBody();
	}
	
	//localhost:9000/api/v1/planet/
	@PostMapping(path="/")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<DTO_Planet> post(@RequestBody DTO_Planet dTO_Planet) {
		
		DTO_Planet result = new DTO_Planet();
		
		try {
			
			result = service_Planet.post(dTO_Planet);
			log.debug("Controller_Planet : post()");
		} catch (Exception e) {
			log.error("Error en Controller_Planet : post()");
		}
		
		return ResponseEntity.status(201).body(result);
		
	}
	
	//localhost:9000/api/v1/planet/{id}
	@PutMapping(path = "/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<DTO_Planet> put(@RequestBody DTO_Planet dTO_Planet, @PathVariable int id) {
		
		DTO_Planet result = new DTO_Planet();
		
		try {

			result = service_Planet.put(dTO_Planet, id);
			log.debug("Controller_Planet : put()");
		} catch (Exception e) {
			log.error("Error en Controller_Planet : put()");
		}
		
		dTO_Planet.setId(result.getId());
		
		return ResponseEntity.status(201).body(dTO_Planet);
		
	}
	
	//localhost:9000/api/v1/planet/{id}
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		boolean result = service_Planet.delete(id);
		
		if(result) {
			log.debug("Controller_Planet : delete()");
			return ResponseEntity.status(204).body("");
		}
		else {
			log.error("Error en Controller_Planet : delete()");
			return ResponseEntity.status(204).body("No funciona");
		}
		
		
		
	}
	
	
}
