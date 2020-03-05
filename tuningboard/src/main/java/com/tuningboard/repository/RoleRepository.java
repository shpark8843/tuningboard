package com.tuningboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuningboard.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
}