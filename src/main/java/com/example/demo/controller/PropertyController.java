package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PersonAttribute;

@RestController
public class PropertyController {

	@Autowired
	private PersonAttribute personAttribute;

	@RequestMapping("/msg")
	public String showMsg() {
		return personAttribute.toString();
	}
}
