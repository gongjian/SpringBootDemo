package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Spring Boot");
		
		model.addAttribute("nameList", Arrays.asList("Java", "C", "Go"));
		
		System.out.println(">>>>>>>>>>>>>>>> Locale: " + LocaleContextHolder.getLocale());
		
		return "Hello";
	}

}
