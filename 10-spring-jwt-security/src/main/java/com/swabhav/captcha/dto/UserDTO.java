package com.swabhav.captcha.dto;

import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.swabhav.captcha.entity.User;

import lombok.Data;

@Data
public class UserDTO {
	private Integer userId;
	private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL) // Ignore if null
	private String password;
    @JsonInclude(JsonInclude.Include.NON_NULL) // Ignore if null
	private java.util.List<String> roles;
	
	public static UserDTO toDTO(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(user.getUserId());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		if(user.getRoles() != null)
		userDto.setRoles(user.getRoles().stream().map(role->role.getName()).collect(Collectors.toList()));
		return userDto;
	}
	
	public static User toUser(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		return user;
	}
}
