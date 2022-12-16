package com.challenge.touwolf.app.rrhh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppHumanResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppHumanResourcesApplication.class, args);
	}
}
