package com.SC403_ProyectoWeb.Grupo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.SC403_ProyectoWeb.Grupo2")
public class Grupo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo2Application.class, args);
	}

}
