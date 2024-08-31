package com.swabhav.captcha.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class JwtAuthResponse {
	private String accessToken;
	private final String tokenType="Bearer";
}
