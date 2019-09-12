package com.example.demo.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity(name = "api_Planet")
public class Planet extends Base{

	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	@Column(name = "planet_name")
	private String name;
	
	@Column(name = "planet_size")
	private double size;
	
	//RELACIONES
	@OneToMany(mappedBy = "planets")
	private Star star;
	
	//CONSTRUCTOR
	public Planet() {}

	public Planet(String name, double size) {
		this.name = name;
		this.size = size;
	}

	
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}

	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	
	
	
}
