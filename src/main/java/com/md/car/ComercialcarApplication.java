package com.md.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.md.car.security.SpringSecurityAuditorAware;


@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ComercialcarApplication {
	
	
/*	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	} 
	
	@Bean
	public JavaMailSender emailSender() {
		return new JavaMailSenderImpl();
	} */

	public static void main(String[] args) {
		SpringApplication.run(ComercialcarApplication.class, args);
	}
}
