package com.swabhav.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.employee.entity.Employee;
import com.swabhav.employee.service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}


	@Override
	public void addEmployee(Employee emp) {
		employeeRepository.addEmployee(emp);
	}


	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployee(id);
	}
	
}
