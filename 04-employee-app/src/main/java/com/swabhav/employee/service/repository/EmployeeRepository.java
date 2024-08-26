package com.swabhav.employee.service.repository;

import java.util.List;

import com.swabhav.employee.entity.Employee;

public interface EmployeeRepository {
	List<Employee> getAllEmployees();
	
	void addEmployee(Employee emp);
	
	Employee getEmployee(int id);
}
