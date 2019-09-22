package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "api_Star")
@DiscriminatorValue("star")
public class Star extends Base{

	private static final long serialVersionUID = 1L;

	//ATRIBUTOS
	@Column(name = "star_name")
	private String name;
	
	@Column(name = "star_density")
	private double density;
	
	
	//RELACIONES
	@OneToMany(mappedBy = "star")
    private List<Planet> planets;
	
	
	//CONSTRUCTOR
	public Star() {
		this.planets = new ArrayList<>();
	}
	
	public Star(String name, double density, List<Planet> planets) {
		this.name = name;
		this.density = density;
		this.planets = planets;
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
	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}
	
	
}
