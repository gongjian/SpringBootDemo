package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserLogin;

public interface UserLoginDao extends CrudRepository<UserLogin, Long>{
	
	UserLogin findByLoginName(String loginName);

}
