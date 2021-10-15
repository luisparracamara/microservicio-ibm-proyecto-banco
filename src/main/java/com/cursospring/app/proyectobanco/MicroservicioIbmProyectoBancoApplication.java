package com.cursospring.app.proyectobanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroservicioIbmProyectoBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioIbmProyectoBancoApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
