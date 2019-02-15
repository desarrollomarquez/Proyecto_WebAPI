package com.api.cloud.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutosApplication.class, args);
	}
}
