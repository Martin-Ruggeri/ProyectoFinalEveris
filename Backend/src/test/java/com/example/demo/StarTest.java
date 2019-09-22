package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.demo.Entity.Planet;
import com.example.demo.Entity.Star;

import static org.junit.Assert.*;
import org.junit.Before;

public class StarTest {
    
    static Logger log = Logger.getLogger(StarTest.class);
	
    private Star star;
    private static Planet p1;
    private static Planet p2;
            
    public StarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    	
        // Crea un archivo HTML, llamado Messages_Tests que esta guardado en la carpeta Raiz
    	PropertyConfigurator.configure("log4j_Test.properties");
        
    	log.debug("Se a iniciado el Test Star");
        p1 = new Planet("Tierra", 3, null);
        p2 = new Planet("Martes", 3.1, null);
    }
    
    @AfterClass
    public static void tearDownClass() {
        p1 = null;
        p2 = null;
    }

    
    @Before
    public void setUp() {
        this.star = new Star();
    }
    
    @After
    public void tearDown() {
        this.star = null;
    }
    
    
    @Test
    public void test_Set_Get_Name() {
        String expResult = "Centauro";
        star.setName("Centauro");
        String result = star.getName();
        try {
            assertEquals(expResult, result);
            log.debug("Test Star: test_Set_Get_Name(): TEST Pasado Correctamente ");
		} catch (AssertionError e) {
			log.error("Test Star: test_Set_Get_Name(): TEST Fallido");
			e.notify();
		}
    }

    @Test
    public void test_Set_Get_Density() {
        double expResult = 1.75;
        star.setDensity(1.75);
        double result = star.getDensity();
        try {
            assertEquals(expResult, result, 0.0);
            log.debug("Test Star: test_Set_Get_Density(): TEST Pasado Correctamente");	
		} catch (AssertionError e) {
			log.error("Tese Star: test_Set_Get_Density(): TEST Fallido");
			e.notify();
		}
    }

    @Test
    public void test_Set_Get_Planets() {
        List<Planet> expResult = new ArrayList<>();
        expResult.add(p1); expResult.add(p2);
        List<Planet> planets = new ArrayList<>();
        planets.add(p1); planets.add(p2);
        star.setPlanets(planets);
        try {
        	assertEquals(expResult.size() , star.getPlanets().size());
            for (int i = 0; i < star.getPlanets().size(); i++) {
                assertEquals(expResult.get(i), star.getPlanets().get(i));   
            }
            log.debug("Test Star: test_Set_Get_Planets(): TEST Pasado Correctamente");
		} catch (AssertionError e) {
			log.error("Test Star: test_Set_Get_Planets(): TEST Fallido");
			e.notify();
		}
    }

    @Test
    public void testAddPlanet() {
        star.addPlanet(p1); star.addPlanet(p2);
        List<Planet> expResult = new ArrayList<>();
        expResult.add(p1); expResult.add(p2);
        List<Planet> result = star.getPlanets();
        try {
        	assertEquals(expResult.size() , star.getPlanets().size());
            for (int i = 0; i < result.size(); i++) {
                assertEquals(expResult.get(i), result.get(i));   
            }
            log.debug("Test Star: testAddPlanet(): TEST Pasado Correctamente");	
		} catch (AssertionError e) {
			log.error("Test Star: testAddPlanet(): TEST Fallido");
			e.notify();
		}
    }
    
}
