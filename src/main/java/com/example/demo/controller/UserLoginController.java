package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserLoginDao;
import com.example.demo.model.UserLogin;

@RestController
public class UserLoginController {

	@Autowired
	private UserLoginDao userLoginDao;

	@RequestMapping("/login")
	public String login(String userName) {
		UserLogin user = userLoginDao.findByLoginName(userName);

		if (user == null) {
			return "Login Error";
		} else {
			return user.getLoginName() + " " + user.getLoginPassword();
		}
	}

}
