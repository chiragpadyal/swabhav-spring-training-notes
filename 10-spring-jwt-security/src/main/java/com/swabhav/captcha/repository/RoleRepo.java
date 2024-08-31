package com.swabhav.captcha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swabhav.captcha.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(String name);
}
