package com.university.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.academic.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	

}
