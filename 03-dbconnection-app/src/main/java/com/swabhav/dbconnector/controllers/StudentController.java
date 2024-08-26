package com.swabhav.dbconnector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.dbconnector.entities.Student;
import com.swabhav.dbconnector.repositories.StudentRepository;
import com.swabhav.dbconnector.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable Integer id) {
		return ResponseEntity.ok(studentService.getStudent(id));
	}
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		studentService.addStudent(student);
		return ResponseEntity.ok("added");
	}
	
	@GetMapping("/students/byname")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
		return ResponseEntity.ok(studentService.getStudentsByName(name));
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		try {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("deleted");
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed");
		}
	}
}
