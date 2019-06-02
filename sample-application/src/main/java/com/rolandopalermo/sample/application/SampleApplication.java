package com.rolandopalermo.sample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.rolandopalermo.sample.*")
@EnableJpaRepositories(basePackages = { "com.rolandopalermo.sample.repository" })
@EntityScan(basePackages = { "com.rolandopalermo.sample.repository.domain" })
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}