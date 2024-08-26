package com.swabhav.dbconnector.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@Column(name = "rollnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;

	@Column(name = "age")
	private int age;

	@Column(name = "name")
	private String name;

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int rollnumber, int age, String name) {
		this.rollnumber = rollnumber;
		this.age = age;
		this.name = name;
	}

	public Student() {
	}

}
