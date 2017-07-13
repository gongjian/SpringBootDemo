package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.gj.test.annotation.EnableLogStarter;

@SpringBootApplication
@EnableLogStarter
@PropertySource("classpath:/tomcat.ssl.properties")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
