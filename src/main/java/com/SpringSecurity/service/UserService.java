package com.SpringSecurity.service;

import java.util.List;

import com.SpringSecurity.entity.User;

public interface UserService {

	public User saveUser(User user);
	public List<User> viewUser();
	public User searchUserById(long id);
	public User updateUserById(User updateUser,long id);
	public void deleteById(long id);
}
