package com.swabhav.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.di.entities.Computer;
import com.swabhav.di.entities.HardDisk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ComputerController {
	@Autowired
	private Computer computer;
	
	@Autowired
	private HardDisk harddisk;

	@GetMapping("computer")
	public Computer getComputer() {
		return computer;
	}
	
	@GetMapping("harddisk")
	public HardDisk getHardDisk() {
		return harddisk;
	}
	
	
	
}
