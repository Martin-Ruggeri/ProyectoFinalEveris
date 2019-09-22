package com.example.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.demo.Entity.Planet;
import com.example.demo.Entity.Star;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class PlanetTest {
    
    static Logger log = Logger.getLogger(PlanetTest.class);
	
    private Planet planet;
    private static Star star;
    
    public PlanetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    	// Crea un archivo HTML, llamado logger_Message que esta guardado en la carpeta Raiz
        PropertyConfigurator.configure("log4j_Test.properties");
        
    	log.debug("Se a iniciado el Test Planet");
        star = new Star("Luna", 2.54, null);
    }
    
    @AfterClass
    public static void tearDownClass() {
        star = null;
    }
    
    @Before
    public void setUp() {
        this.planet = new Planet();
    }
    
    @After
    public void tearDown() {
        this.planet = null;
    }

    @Test
    public void test_Set_Get_Name() {
        String expResult = "Venus";
        planet.setName("Venus");
        String result = planet.getName();
        try {
            assertEquals(expResult, result);
            log.debug("Test Planet: test_Set_Get_Name(): TEST Pasado Correctamente");
		} catch (AssertionError e) {
			log.error("Test Planet: test_Set_Get_Name(): TEST Fallido");
			e.notify();
		}
    }

    @Test
    public void test_Set_Get_Size() {
        double expResult = 2.598;
        planet.setSize(2.598);
        double result = planet.getSize();
        try {
        	assertEquals(expResult, result, 0.0);
        	log.debug("Test Planet: test_Set_Get_Size(): TEST Pasado Correctamente");
		} catch (AssertionError e) {
			log.error("Test Planet: test_Set_Get_Name(): TEST Fallido");
			e.notify();
		}
    }

    @Test
    public void test_Set_Get_Star() {
        Star expResult = star;
        planet.setStar(star);
        Star result = planet.getStar();
        try {
            assertEquals(expResult, result);
            log.debug("Test Planet: test_Set_Get_Star(): TEST Pasado Correctamente");	
		} catch (AssertionError e) {
			log.error("Test Planet: test_Set_Get_Star(): TEST Fallido");
			e.notify();
		}
    }
}
