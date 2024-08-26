package com.swabhav.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.bank.entities.Address;
import com.swabhav.bank.entities.Student;
import com.swabhav.bank.services.StudentService;

@RestController
@RequestMapping("/studentapp/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public ResponseEntity<List<Student>> getAll(){
		return ResponseEntity.ok(studentService.getAllStudent());
	}
	
	
	@GetMapping("{rollnumber}")
	public ResponseEntity<Student> get(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getStudentById(rollnumber));
	}
	
	@GetMapping("{rollnumber}/address")
	public ResponseEntity<Address> getWithAddress(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getAddressByStudentID(rollnumber));
	}
	
	@PostMapping("")
	public ResponseEntity<Student> post(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@PutMapping("")
	public ResponseEntity<String> put(@RequestBody Student student){
		studentService.updateStudent(student);
		return ResponseEntity.ok("Success");
	}
	
	@DeleteMapping("{rollnumber}")
	public ResponseEntity<String> delete(@PathVariable int rollnumber){
		studentService.deleteStudent(rollnumber);
		return ResponseEntity.ok("Success");
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @RequestParam int rollnumber){
		return ResponseEntity.ok(studentService.updateAddressByStudentID(rollnumber, address));
	}
	
	
	
}
