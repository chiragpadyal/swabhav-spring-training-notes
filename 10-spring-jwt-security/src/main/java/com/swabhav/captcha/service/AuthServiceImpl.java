package com.swabhav.captcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.swabhav.captcha.dto.LoginDTO;
import com.swabhav.captcha.dto.UserDTO;
import com.swabhav.captcha.exception.UserApiException;
import com.swabhav.captcha.security.JwtTokenProvider;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public String login(LoginDTO loginDTO) {
		try {
			Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
					);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String tokenString = jwtTokenProvider.generateToken(authentication);
			return tokenString;
		}catch (BadCredentialsException e) {
			throw new UserApiException(HttpStatus.NOT_FOUND, "User not found");
		}
	}

	@Override
	public UserDTO register(UserDTO userDTO) {
		return userService.addUser(userDTO);
	}
	
	
}
