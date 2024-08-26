package com.swabhav.bank.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Course;
import com.swabhav.bank.entities.Instructor;
import com.swabhav.bank.repositories.CourseRepo;
import com.swabhav.bank.repositories.InstructorRepo;
import com.swabhav.crud.dto.CourseDto;
import com.swabhav.crud.dto.InstructorDto;
import com.swabhav.crud.dto.PageResponse;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepo instructorRepo;
	
	@Autowired
	CourseRepo courseRepo;

	@Override
	public Instructor getInstructor(Integer id) {
		return instructorRepo.findById(id).orElseThrow();
	}

	@Override
	public PageResponse<InstructorDto> getInstructors(int pageSize, int pageNo) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Instructor> instructorsPage =  instructorRepo.findAll(pageable);
		Page<InstructorDto> instructorDtoPage =  instructorsPage.map(new InstructorDto()::toDto);
		PageResponse<InstructorDto> instructorDtoPageResponse = PageResponse.toPageResponse(instructorDtoPage);
		return instructorDtoPageResponse;
	}

	@Override
	public void deleteInstructor(Integer id) {
		instructorRepo.deleteById(id);
	}

	@Override
	public Instructor updateInstructor(Integer id, InstructorDto instructor) {
		if(instructorRepo.existsById(id)) return instructorRepo.save(instructor.toInstructor());
		return null;
	}

	@Override
	public Instructor insertInstructor(InstructorDto instructor) {
		return instructorRepo.save(instructor.toInstructor());
	}

	@Override
	public Instructor allocateCourse(Integer id, List<CourseDto> coursesDto) {
		Optional<Instructor> instructorOptional = instructorRepo.findById(id);
		if(instructorOptional.isPresent()) {
			Instructor instructor = instructorOptional.get();
			List<Course> oldCourses = instructor.getCourses();
			List<Course> courses = new ArrayList<Course>(oldCourses);
			for (CourseDto courseDto : coursesDto) {
				Course course = courseRepo.findById(courseDto.getCourseId()).get();
				course.setInstructor(instructor);
				if(!courses.contains(course)) courses.add(course);
			};
			instructor.setCourses(courses);
			instructorRepo.save(instructor);
			return instructor;
		}
		return null;
	}

	@Override
	public List<CourseDto> getInstructorCourses(Integer instructorId) {
		Instructor instructor = instructorRepo.findById(instructorId).orElseThrow();
		List<CourseDto> courseDtos = new ArrayList<>();
		for(Course course: instructor.getCourses()) {
			courseDtos.add(new CourseDto().toDto(course));
		}
		return courseDtos;
	}

}
