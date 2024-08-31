package com.swabhav.captcha.service;

import com.swabhav.captcha.dto.LoginDTO;
import com.swabhav.captcha.dto.UserDTO;

public interface AuthService {
	String login(LoginDTO loginDTO);
	UserDTO register(UserDTO userDTO);
}
