package com.example.demo.service.aop;

import org.springframework.stereotype.Service;

import com.example.demo.annotation.Action;

@Service
public class DemoAnnotationService {

	@Action(name = "注解拦截add方法")
	public void add() {

	}
}
