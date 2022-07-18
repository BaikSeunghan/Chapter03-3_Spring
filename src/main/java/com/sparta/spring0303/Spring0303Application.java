package com.sparta.spring0303;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Spring0303Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring0303Application.class, args);
	}

}
