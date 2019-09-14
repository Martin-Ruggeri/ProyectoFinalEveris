package com.example.demo.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "api_Planet")
@DiscriminatorValue("planet")
public class Planet extends Base{
	
	private static final long serialVersionUID = 1L;

	//ATRIBUTOS
	@Column(name = "planet_name")
	private String name;
	
	@Column(name = "planet_size")
	private double size;
	
	//RELACIONES
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "Star.id")
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
