package com.gabrielblanco.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// use este @ para inicial punto de entrada a una app SpringBoot
@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		// con este levantamos el servidor en el puente 8080
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
}
