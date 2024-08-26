package com.swabhav.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swabhav.di.entities.Computer;
import com.swabhav.di.entities.HardDisk;

@Configuration
public class ApplicationConfig {
	@Bean
	public Computer getComputer() {
		return new Computer();
	}
	
	@Bean 
	public HardDisk getHardDisk() {
		return new HardDisk();
	}
}
