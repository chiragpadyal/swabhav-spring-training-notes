package com.swabhav.dbconnector.service;

import java.util.List;

import com.swabhav.dbconnector.entities.Student;

public interface StudentService {
		List<Student> getAllStudents();
		Student getStudent(int rollnumber);
		void deleteStudent(int rollnumber);
		void addStudent(Student student);
		List<Student> getStudentsByName(String name);
}
