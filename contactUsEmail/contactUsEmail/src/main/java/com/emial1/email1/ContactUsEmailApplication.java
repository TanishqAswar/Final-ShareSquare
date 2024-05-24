package com.emial1.email1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.emial1.email1.Model")
public class ContactUsEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactUsEmailApplication.class, args);
	}

}
