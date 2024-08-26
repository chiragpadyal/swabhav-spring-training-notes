package com.swabhav.employee.service;

import java.util.List;

import com.swabhav.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	void addEmployee(Employee emp);
	
	Employee getEmployee(int id);
}
