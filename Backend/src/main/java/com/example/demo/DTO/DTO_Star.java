package com.example.demo.DTO;

import com.example.demo.Entity.Base;

public class DTO_Star extends Base{
	
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private String name;
	private double density;
	
	//CONSTRUCTOR
	public DTO_Star() {}

	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getDensity() {
		return density;
	}
	public void setDensity(double density) {
		this.density = density;
	}
	
	
	
}
