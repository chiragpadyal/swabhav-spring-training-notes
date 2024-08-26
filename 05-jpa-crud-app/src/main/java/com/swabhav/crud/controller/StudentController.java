package com.swabhav.crud.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.crud.entities.Student;
import com.swabhav.crud.service.StudentService;

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
	
	@PostMapping("")
	public ResponseEntity<String> post(@RequestBody Student student){
		studentService.addStudent(student);
		return ResponseEntity.ok("Success");
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
	
	@GetMapping("similar")
	public ResponseEntity<List<Student>> similar(@RequestBody Student student){
		return ResponseEntity.ok(studentService.findSimilarStudent(student));
	}
		
}
