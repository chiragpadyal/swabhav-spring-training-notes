package com.swabhav.crud.service;

import java.util.List;

import com.swabhav.crud.entities.Student;

public interface StudentService {

	List<Student> getAllStudent();

	Student getStudentById(int rollnumber);

	List<Student> findSimilarStudent(Student student);

	void addStudent(Student student);

	void deleteStudent(int rollnumber);

	void updateStudent(Student student);
}
