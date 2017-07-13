package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.aop.DemoAnnotationService;
import com.example.demo.service.aop.DemoMethodService;

@RunWith(SpringRunner.class)
@SpringBootTest
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
