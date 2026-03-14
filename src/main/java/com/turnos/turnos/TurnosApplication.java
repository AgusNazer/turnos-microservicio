package com.turnos.turnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan("com.turnos.turnos.models")
@EnableJpaRepositories("com.turnos.turnos.repository")
public class TurnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnosApplication.class, args);
	}

}
