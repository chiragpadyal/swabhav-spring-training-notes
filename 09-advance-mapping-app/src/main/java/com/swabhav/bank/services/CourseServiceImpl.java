package com.swabhav.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Course;
import com.swabhav.bank.repositories.CourseRepo;
import com.swabhav.crud.dto.CourseDto;
import com.swabhav.crud.dto.InstructorDto;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepo courseRepo;

	@Override
	public Course getCourse(Integer id) {
		return courseRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}

	@Override
	public void deleteCourse(Integer id) {
		courseRepo.deleteById(id);
	}

	@Override
	public Course updateCourse(Integer id, CourseDto course) {
		if(courseRepo.existsById(id)) return courseRepo.save(course.toCourse());
		return null;
	}

	@Override
	public Course insertCourse(CourseDto course) {
		return courseRepo.save(course.toCourse());
	}

	@Override
	public Course allocateInstructor(Integer id, InstructorDto instructorDto) {
		Course course = courseRepo.findById(id).get();
		course.setInstructor(instructorDto.toInstructor());
		courseRepo.save(course);
		return course;
	}

}
