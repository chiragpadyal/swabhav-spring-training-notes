package com.swabhav.bank.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.swabhav.bank.entities.Instructor;
import com.swabhav.crud.dto.CourseDto;
import com.swabhav.crud.dto.InstructorDto;
import com.swabhav.crud.dto.PageResponse;

public interface InstructorService {
	Instructor getInstructor(Integer id);
	PageResponse<InstructorDto> getInstructors(int pageSize, int pageNo);
	void deleteInstructor(Integer id);
	Instructor updateInstructor(Integer id, InstructorDto instructor);
	Instructor insertInstructor(InstructorDto instructor);
	Instructor allocateCourse(Integer id, List<CourseDto> courses);
	List<CourseDto> getInstructorCourses(Integer instructorId);
}
