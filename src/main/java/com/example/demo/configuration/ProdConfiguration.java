package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.model.PersonAttribute;

@Configuration
@Profile("prod")
@PropertySource("classpath:person-prod.properties")
public class ProdConfiguration {
	
	@Bean	
	public PersonAttribute personAttribute(){
		return new PersonAttribute();
	}

}