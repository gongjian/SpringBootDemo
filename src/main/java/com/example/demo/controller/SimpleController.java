package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SimpleService;

@RestController
public class SimpleController {

	@Autowired
	private SimpleService simpleService;

	@RequestMapping("/runService")
	public void runService() {
		int num = 666;
		simpleService.core(num);
		simpleService.test(num);
		simpleService.work(num);
	}

}
