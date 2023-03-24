package com.crud.project.SpringBootNimapTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
@ComponentScan(basePackages = "com.curd.project.controller," + "com.curd.project.service")
@EntityScan(basePackages = "com.crud.project.entity")
@EnableJpaRepositories(basePackages = "com.crud.project.repository")
public class SpringBootNimapTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNimapTaskApplication.class, args);
	}

}
