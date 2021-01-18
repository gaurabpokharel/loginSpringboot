package com.SpringSecurity.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecurity.entity.User;
import com.SpringSecurity.repo.UserRepo;
import com.SpringSecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public User searchUserById(long id) {
		return userRepo.findById(id).get();
	}
	@Override
	public List<User> viewUser() {
		return userRepo.findAll();
	}
	@Override
	public User updateUserById(User updateUser, long id) {
		updateUser.setId(id);
		return userRepo.save(updateUser);
	}
	@Override
	public void deleteById(long id) {
		userRepo.deleteById(id);
	}
	
}
