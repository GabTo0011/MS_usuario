package com.perfulandia.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.perfulandia.usuarios"})
public class GestionDeUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeUsuarioApplication.class, args);
	}

}
