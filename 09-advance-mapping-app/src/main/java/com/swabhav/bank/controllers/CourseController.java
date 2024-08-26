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
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.bank.entities.Course;
import com.swabhav.bank.services.CourseService;
import com.swabhav.crud.dto.CourseDto;


@RestController
@RequestMapping("/studentapp/courses")
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping("{id}")
	public ResponseEntity< Course > getCourse(@PathVariable Integer id) {
		return ResponseEntity.ok(courseService.getCourse(id));
	}
	
	@GetMapping("")
	public ResponseEntity< List<Course>> getCourses() {
		return ResponseEntity.ok(courseService.getCourses());
	}
	
	@PostMapping("")
	public ResponseEntity<Course> addCourse(@RequestBody CourseDto course) {
		return ResponseEntity.ok(courseService.insertCourse(course));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Course> addCourse(@PathVariable Integer id, @RequestBody CourseDto course) {
		return ResponseEntity.ok(courseService.updateCourse(id, course));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
		courseService.deleteCourse(id);
		return ResponseEntity.ok("deleted");
	}
	
	
	
}
