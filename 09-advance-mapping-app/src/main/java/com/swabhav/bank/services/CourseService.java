package com.swabhav.bank.services;

import java.util.List;

import com.swabhav.bank.entities.Course;
import com.swabhav.crud.dto.CourseDto;
import com.swabhav.crud.dto.InstructorDto;

public interface CourseService {
	Course getCourse(Integer id);
	List<Course> getCourses();
	void deleteCourse(Integer id);
	Course updateCourse(Integer id, CourseDto instructor);
	Course insertCourse(CourseDto instructor);
	Course allocateInstructor(Integer id, InstructorDto instructorDto);
}
