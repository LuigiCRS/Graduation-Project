package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	
	public UserController() {
		this.userService = new UserService();
	}


	@PostMapping("/run")
	public User runApplication(@RequestBody User user) {
		return userService.runApp(user);
		
	}
	
	@GetMapping()
	public String getName() {
		return "done";
		
	}
	
}
