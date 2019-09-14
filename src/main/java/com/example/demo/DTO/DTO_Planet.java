package com.example.demo.DTO;

import com.example.demo.Entity.Base;

public class DTO_Planet extends Base{

	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private String name;
	private double size;
	
	//CONSTRUCTOR
	public DTO_Planet() {
		
	}

	//GETTERS AND SETTERS
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
