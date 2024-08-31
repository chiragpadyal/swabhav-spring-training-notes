package com.swabhav.captcha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swabhav.captcha.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
