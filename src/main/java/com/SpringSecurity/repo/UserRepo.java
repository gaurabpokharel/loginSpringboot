package com.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {

	User findByEmail(String email);
}
