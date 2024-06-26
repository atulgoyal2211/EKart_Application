package com.company.ekart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class EkartApplication{
	
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(EkartApplication.class, args);
		
	}

}
