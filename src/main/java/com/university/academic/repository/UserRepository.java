package com.university.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.academic.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	boolean existsByUsername(String username);
	
}
