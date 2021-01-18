package com.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.security.SecurityService;

@RestController

public class UserController {

	@Autowired
	private SecurityService securityService;
	
	
	@PostMapping("/login")
	public boolean login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		boolean login=securityService.login(email, password);
		return login;
	}
	
}
