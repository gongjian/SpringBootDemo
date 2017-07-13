package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.aop.DemoAnnotationService;
import com.example.demo.service.aop.DemoMethodService;

@RestController
public class AopController {

	@Autowired
	private DemoAnnotationService demoAnnotationService;

	@Autowired
	private DemoMethodService demoMethodService;

	@RequestMapping("/runAop")
	public void runAop() {

		demoAnnotationService.add();

		demoMethodService.add();

	}

}
