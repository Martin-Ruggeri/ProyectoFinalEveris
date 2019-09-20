package com.example.demo.DTO;

public class DTO_Planet extends DTO_Base{
	
    
	//ATRIBUTOS
	private String name;
	private double size;
	
	//RELACION
	private DTO_Star dTO_Star;
	
	//CONSTRUCTOR
	public DTO_Planet() {}

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

	public DTO_Star getdTO_Star() {
		return dTO_Star;
	}

	public void setdTO_Star(DTO_Star dTO_Star) {
		this.dTO_Star = dTO_Star;
	}
	
	
	
}
