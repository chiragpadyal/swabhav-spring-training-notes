package com.swabhav.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.swabhav.crud.dto.PageResponse;
import com.swabhav.crud.entities.Student;

public interface StudentService {

	List<Student> getAllStudent();

	Student getStudentById(int rollnumber);

	Page<Student> findSimilarStudent(Student student, int pageSize, int pageNo);

	void addStudent(Student student);

	void deleteStudent(int rollnumber);

	void updateStudent(Student student);
	
	PageResponse<Student> getAllStudentByPage(int pageSize, int pageNo);
}
