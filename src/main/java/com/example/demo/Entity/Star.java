package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


public class Star extends Base{

	private static final long serialVersionUID = 1L;

	//ATRIBUTOS
	@Column(name = "star_name")
	private String name;
	
	@Column(name = "star_density")
	private double density;
	
	
	//RELACIONES
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "Planet.id")
    private List<Planet> planets;
	
	
	//CONSTRUCTOR
	public Star() {}
	
	public Star(String name, double density) {
		this.name = name;
		this.density = density;
	}

	
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

	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	
	
}
