package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoObj;

@RestController
public class ConverterController {

	@RequestMapping(value = "/convert", produces = "application/gongjian")
	public DemoObj convert(@RequestBody DemoObj demoObj) {
		return demoObj;
	}
}
