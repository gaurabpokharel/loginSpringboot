package com.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {

}
