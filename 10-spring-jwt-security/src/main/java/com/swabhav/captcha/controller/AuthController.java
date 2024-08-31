package com.swabhav.captcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.captcha.dto.JwtAuthResponse;
import com.swabhav.captcha.dto.LoginDTO;
import com.swabhav.captcha.dto.UserDTO;
import com.swabhav.captcha.service.AuthService;

@RestController
@RequestMapping("api")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@PostMapping("login")
	public JwtAuthResponse login(@RequestBody LoginDTO loginDTO){
		String jwt = authService.login(loginDTO);
		return new JwtAuthResponse(jwt);
	}
	
	@PostMapping("register")
	public UserDTO register(@RequestBody UserDTO userDTO){
		return authService.register(userDTO);
	}
}
