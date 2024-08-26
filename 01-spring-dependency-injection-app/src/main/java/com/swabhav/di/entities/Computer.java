package com.swabhav.di.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class Computer {
	@Value("dell")
	private String name;
	@Autowired
	private HardDisk harddisk;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HardDisk getHarddisk() {
		return harddisk;
	}
	public void setHarddisk(HardDisk harddisk) {
		this.harddisk = harddisk;
	}
	public Computer(String name, HardDisk harddisk) {
		super();
		this.name = name;
		this.harddisk = harddisk;
	}
	public Computer() {
		super();
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", harddisk=" + harddisk + "]";
	}
	
	
}
