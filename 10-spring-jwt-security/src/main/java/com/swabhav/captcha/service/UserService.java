package com.swabhav.captcha.service;

import java.util.List;

import com.swabhav.captcha.dto.UserDTO;
import com.swabhav.captcha.entity.User;

public interface UserService {
	UserDTO getUserDTO(Integer id);
	User getUser(Integer id);
	UserDTO addUser(UserDTO user);
	
	UserDTO appendRoles(Integer userId, List<String> roles);
	List<String> createRole(String roleName);
}
