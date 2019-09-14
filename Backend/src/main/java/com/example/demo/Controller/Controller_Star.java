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

import com.example.demo.DTO.DTO_Star;
import com.example.demo.Service.Service_Star;

@Controller
@RestController
@RequestMapping(path = "api/v1/star")
public class Controller_Star {

	private Service_Star service_Star;

	public Controller_Star(Service_Star service_Star) {
		this.service_Star = service_Star;
	}
	
	@GetMapping(path="/{id}")
	public DTO_Star getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service_Star.getOne(id)).getBody();
	}
	
	@GetMapping(path = "/")
	public List<DTO_Star> getAll(){
		return ResponseEntity.status(200).body(service_Star.getAll()).getBody();
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<DTO_Star> post(@RequestBody DTO_Star dTO_Star){
		DTO_Star resultDTO_Star = new DTO_Star();
		try {
			resultDTO_Star = service_Star.post(dTO_Star);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(201).body(resultDTO_Star);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<DTO_Star> put(@RequestBody DTO_Star dTO_Star, @PathVariable int id){
		DTO_Star resultDTO_Star = new DTO_Star();
		try {
			resultDTO_Star = service_Star.put(dTO_Star, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
			dTO_Star.setId(resultDTO_Star.getId());
			return ResponseEntity.status(201).body(dTO_Star);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		boolean result = service_Star.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("No funciona");
		}
	}
}
