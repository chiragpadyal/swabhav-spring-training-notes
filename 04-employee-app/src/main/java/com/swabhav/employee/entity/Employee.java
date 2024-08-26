package com.swabhav.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int employeeId;
	
	@Column(name = "name")
	String employeeName;
	
	@Column(name = "email")
	String employeeEmail;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "salary")
	double salary;

	public Employee(int employeeId, String employeeName, String employeeEmail, int age, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.age = age;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
