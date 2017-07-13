package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.configuration.TestConfiguration;
import com.example.demo.service.aop.DemoAnnotationService;
import com.example.demo.service.aop.DemoMethodService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class AopTests {
	
	@Autowired
	private DemoAnnotationService demoAnnotationService;
	
	@Autowired
	private DemoMethodService demoMethodService;
	
	@Test
	public void runAnnotationAop(){
		demoAnnotationService.add();		
	}
	
	@Test
	public void runMehtodAop(){
		demoMethodService.add();
	}

}
