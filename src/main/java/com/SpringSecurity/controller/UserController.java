package com.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.entity.User;
import com.SpringSecurity.security.SecurityService;
import com.SpringSecurity.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/login")
	public boolean login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		boolean login=securityService.login(email, password);
		return login;
	}
	
	@PostMapping("/registerUser")
	public User saveUser(@RequestBody User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/viewAllUser")
	public List<User> viewAllUSer()
	{
		return userService.viewUser();
	}
	
	@GetMapping("/viewUserById/{id}")
	public User viewById(@PathVariable long id)
	{
		return userService.searchUserById(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User updateUser,@PathVariable long id)
	{
		return userService.updateUserById(updateUser, id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable long id)
	{
		 userService.deleteById(id);
	}
}
