package com.swabhav.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.swabhav.bank.entities.Instructor;
import com.swabhav.bank.services.InstructorService;
import com.swabhav.crud.dto.CourseDto;
import com.swabhav.crud.dto.InstructorDto;
import com.swabhav.crud.dto.PageResponse;


@RestController
@RequestMapping("/studentapp/instructors")
public class InstructorController {
	@Autowired
	InstructorService instructorService;

	@GetMapping("{id}")
	public ResponseEntity< Instructor > getInstructor(@PathVariable Integer id) {
		return ResponseEntity.ok(instructorService.getInstructor(id));
	}
	
	@GetMapping("")
	public ResponseEntity< PageResponse<InstructorDto>> getInstructors(@RequestParam int pageSize, @RequestParam int pageNo) {
		return ResponseEntity.ok(instructorService.getInstructors(pageSize, pageNo));
	}
	
	@PostMapping("")
	public ResponseEntity<Instructor> addInstructor(@RequestBody InstructorDto instructor) {
		return ResponseEntity.ok(instructorService.insertInstructor(instructor));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Instructor> addInstructor(@PathVariable Integer id, @RequestBody InstructorDto instructor) {
		return ResponseEntity.ok(instructorService.updateInstructor(id, instructor));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable Integer id) {
		instructorService.deleteInstructor(id);
		return ResponseEntity.ok("deleted");
	}
	
	
	@PutMapping("{id}/course")
	public ResponseEntity<Instructor> allocateCourse(@PathVariable Integer id, @RequestBody List<CourseDto> courses) {
		return ResponseEntity.ok(instructorService.allocateCourse(id, courses));
	}
	
	@GetMapping("{id}/course")
	public ResponseEntity< List<CourseDto>> getInstructorCourses(@PathVariable Integer id) {
		return ResponseEntity.ok(instructorService.getInstructorCourses(id));
	}
}
