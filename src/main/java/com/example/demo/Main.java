package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.configuration.TestConfiguration;
import com.example.demo.service.aop.DemoAnnotationService;
import com.example.demo.service.aop.DemoMethodService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
		DemoAnnotationService service1 = context.getBean(DemoAnnotationService.class);
		DemoMethodService service2 =  context.getBean(DemoMethodService.class);
		
		service1.add();
		service2.add();
		
		context.close();
	}

}
