package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.model.PersonAttribute;

@Configuration
@Profile("dev")
@PropertySource("classpath:person-dev.properties")
public class DevConfiguration {
	
	@Bean	
	public PersonAttribute personAttribute(){
		return new PersonAttribute();
	}

}
