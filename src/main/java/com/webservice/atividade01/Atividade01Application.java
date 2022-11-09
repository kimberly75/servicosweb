package com.webservice.atividade01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.webservice.atividade01.model"
        })
@EnableJpaRepositories(basePackages = {
        "com.webservice.atividade01.repository"
        })
public class Atividade01Application {

	public static void main(String[] args) {
		SpringApplication.run(Atividade01Application.class, args);
	}

}
