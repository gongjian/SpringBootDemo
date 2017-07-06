package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.entity.PersonAttribute;

@Configuration
@Profile("prod")
@PropertySource("classpath:person-prod.properties")
public class ProdConfig {
	
	@Bean	
	@ConfigurationProperties(prefix="person")
	public PersonAttribute personAttribute(){
		return new PersonAttribute();
	}

}