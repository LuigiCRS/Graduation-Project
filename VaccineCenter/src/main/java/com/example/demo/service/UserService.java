package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.boundary.Application;
import com.example.demo.entity.User;

@Service
public class UserService {


	
	public User runApp(User user) {
		Application app = new Application(user);
		app.start();
		return user;
	}
}
