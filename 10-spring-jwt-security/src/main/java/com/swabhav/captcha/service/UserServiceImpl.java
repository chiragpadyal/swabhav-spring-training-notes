package com.swabhav.captcha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swabhav.captcha.dto.UserDTO;
import com.swabhav.captcha.entity.Role;
import com.swabhav.captcha.entity.User;
import com.swabhav.captcha.exception.UserApiException;
import com.swabhav.captcha.repository.RoleRepo;
import com.swabhav.captcha.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired 
	RoleRepo roleRepo;
	
	@Override
	public User getUser(Integer id) {
		return userRepo.findById(id).orElseThrow();
	}

	
	@Override
	public UserDTO getUserDTO(Integer id) {
		User user = userRepo.findById(id).orElseThrow();
		return UserDTO.toDTO(user);
	}

	@Override
	public UserDTO addUser(UserDTO user) {
		if(user.getUserId() != null) throw new UserApiException(HttpStatus.BAD_REQUEST, "Bad request body");
		if(userRepo.existsByEmail(user.getEmail()))throw new UserApiException(HttpStatus.BAD_REQUEST, "User already exist");
		user.setPassword(encoder.encode(user.getPassword()));
		User userResponse = userRepo.save(UserDTO.toUser(user));
		user = this.appendRoles(userResponse.getUserId(), user.getRoles());
		if(user != null) return user;
		return UserDTO.toDTO(userResponse);
	}

	@Override
	public UserDTO appendRoles(Integer userId, List<String> roleNames) {
		User user = this.getUser(userId);
		List<Role> previousRoles = user.getRoles();
		List<Role> updatedRoles;
		if(previousRoles != null) {
			updatedRoles = new ArrayList<>(previousRoles);
		} else {
			updatedRoles = new ArrayList<>();
		}

		for (String roleName : roleNames) {
			Role fetchedRole = roleRepo.findByName(roleName).orElseThrow(()->new RuntimeException("Role"));
			Set<User> users = fetchedRole.getUsers();
			if(users.contains(user)) throw new RuntimeException("Role");
			users.add(user);
			fetchedRole.setUsers(users);
			updatedRoles.add(fetchedRole);
		}
		user.setRoles(updatedRoles);
		userRepo.save(user);
		return UserDTO.toDTO(user);
	}


	@Override
	public List<String> createRole(String roleName) {
		Optional<Role> fetchedRole = roleRepo.findByName(roleName);
		if(fetchedRole.isPresent()) throw new RuntimeException("role");
		Role role = new Role();
		role.setName(roleName);
		roleRepo.save(role);
		List<Role> roles = roleRepo.findAll();
		List<String> roleNames = roles.stream().map(cRole->cRole.getName()).collect(Collectors.toList());
		return roleNames;
	}
}
