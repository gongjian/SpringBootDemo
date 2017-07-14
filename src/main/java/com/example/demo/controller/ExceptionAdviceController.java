package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionAdviceController {

	@RequestMapping("/advice")
	public void advice(@ModelAttribute("msg") String msg){
		
		throw new IllegalArgumentException("Test exception, " + msg);
		
	}
}
