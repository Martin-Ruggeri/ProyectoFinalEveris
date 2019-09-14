package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

	private Service_Planet service_Planet;
	
	public Controller_Planet(Service_Planet service_Planet) {
		this.service_Planet = service_Planet;
	}

	//localhost:9000/api/v1/planets/{id}
	@GetMapping(path="/{id}")
	public DTO_Planet getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service_Planet.getOne(id)).getBody();
	}
	
	//localhost:9000/api/v1/planets/
	@GetMapping(path="/")
	public List<DTO_Planet> getAll() {
	//	return planetService.getAll();
		return ResponseEntity.status(200).body(service_Planet.getAll()).getBody();
	}
	
	@PostMapping(path="/")
	public ResponseEntity<DTO_Planet> post(@RequestBody DTO_Planet dTO_Planet) {
		
		DTO_Planet result = new DTO_Planet();
		
		try {
			
			result = service_Planet.post(dTO_Planet);
			
		} catch (Exception e) {

		}
		
		return ResponseEntity.status(201).body(result);
		
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<DTO_Planet> put(@RequestBody DTO_Planet dTO_Planet, @PathVariable int id) {
		
		DTO_Planet result = new DTO_Planet();
		
		try {

			result = service_Planet.put(dTO_Planet, id);
			
		} catch (Exception e) {

		}
		
		dTO_Planet.setId(result.getId());
		
		return ResponseEntity.status(201).body(dTO_Planet);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		boolean result = service_Planet.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("No funciona");
		}
		
		
		
	}
	
	
}
