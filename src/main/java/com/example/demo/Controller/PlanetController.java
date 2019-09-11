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

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Service.PlanetService;

@Controller
@RestController
@RequestMapping(path = "api/v1/planets")
public class PlanetController {

	private PlanetService planetService;
	
	public PlanetController(PlanetService planetService) {
		this.planetService = planetService;
	}

	//localhost:9000/api/v1/planets/{id}
	@GetMapping(path="/{id}")
	public PlanetDTO getOne(@PathVariable int id) {

		
		
		return
ResponseEntity.status(200).body(planetService.getOne(id)).getBody();
	}
	
	//localhost:9000/api/v1/planets/
	@GetMapping(path="/")
	public List<PlanetDTO> getAll() {
	//	return planetService.getAll();
		return ResponseEntity.status(200).body(planetService.getAll()).getBody();
	}
	
	@PostMapping(path="/")
	public ResponseEntity post(@RequestBody PlanetDTO planetDTO) {
		
		PlanetDTO result = new PlanetDTO();
		
		try {
			
			result = planetService.post(planetDTO);
			
		} catch (Exception e) {

		}
		
		return ResponseEntity.status(201).body(result);
		
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody PlanetDTO planetDTO, @PathVariable int id) {
		
		PlanetDTO result = new PlanetDTO();
		
		try {
			
			result = planetService.put(planetDTO, id);
			
		} catch (Exception e) {

		}
		
		planetDTO.setId(result.getId());
		
		return ResponseEntity.status(201).body(planetDTO);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = planetService.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("No funciona");
		}
		
		
		
	}
	
	
}
