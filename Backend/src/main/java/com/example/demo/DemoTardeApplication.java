package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SpringBootApplication
public class DemoTardeApplication {

    static Logger log = Logger.getLogger(DemoTardeApplication.class);
    
	public static void main(String[] args) {
        // Crea un archivo HTML, llamado logger_Message que esta guardado en la carpeta Raiz
        PropertyConfigurator.configure("log4j.properties");
        
        log.debug("Se a iniciado Proyecto Final");
		SpringApplication.run(DemoTardeApplication.class, args);
	}

}
