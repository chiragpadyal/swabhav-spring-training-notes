package com.swabhav.di.entities;

import org.springframework.beans.factory.annotation.Value;

public class HardDisk {
	@Value("5")
	private int capacity;

	@Override
	public String toString() {
		return "HardDisk [capacity=" + capacity + "]";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public HardDisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	public HardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
