package com.swabhav.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.employee.entity.Employee;
import com.swabhav.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("all")
	public ResponseEntity<List<Employee>> getAllEMployee(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable String id){
		try {
			int emp_id = Integer.parseInt(id);
			return ResponseEntity.ok(employeeService.getEmployee(emp_id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		return ResponseEntity.ok("done");
	}
}
