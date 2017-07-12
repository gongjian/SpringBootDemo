package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@RequestMapping("/search/{searchType}")
	public Map<String, Object> search(@PathVariable String searchType, @MatrixVariable List<String> keywords) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keywords", keywords);
		
		keywords.forEach(n -> System.out.println(n));

		return map;
	}

	@GetMapping("/session")
	public String session(HttpSession session){
		return session.getId();
	}
}
