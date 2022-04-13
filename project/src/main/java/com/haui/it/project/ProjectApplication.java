package com.haui.it.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication /* (exclude = SecurityConfiguration.class) */
@ComponentScan(basePackages= { "com.haui.it.project.controller.admin" })
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
