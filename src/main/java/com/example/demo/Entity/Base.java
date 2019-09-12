package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Base implements Serializable{
    
	private static final long serialVersionUID = 1L;
	//ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    //CONSTRUCTOR
    public Base() {}
    
    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }
	public void setId(int id) {
		this.id = id;
	}
    
}