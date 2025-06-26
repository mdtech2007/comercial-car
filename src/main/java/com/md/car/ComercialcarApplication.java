package com.md.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ComercialcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComercialcarApplication.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return "Welcome to my world....";
	}
}
