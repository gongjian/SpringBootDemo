package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/getAllUsers")
	public Iterable<User> getAllUsers() {

		Iterable<User> users = userRepository.findAll();

		return users;
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable long id) {
		User user = userRepository.findOne(id);

		return user;
	}

}
