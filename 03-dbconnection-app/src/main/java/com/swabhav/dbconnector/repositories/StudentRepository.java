package com.swabhav.dbconnector.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.swabhav.dbconnector.entities.Student;



public interface StudentRepository {
	List<Student> getAllStudents();
	Student getStudent(int rollnumber);
	void deleteStudent(int rollnumber);
	void addStudent(Student student);
	List<Student> getStudentsByName(String name);
}
