package com.swabhav.bank.services;

import java.util.List;


import com.swabhav.bank.entities.Address;
import com.swabhav.bank.entities.Student;


public interface StudentService {

	List<Student> getAllStudent();

	Student getStudentById(int rollnumber);
	
	Student addStudent(Student student);

	void deleteStudent(int rollnumber);

	void updateStudent(Student student);
	Address getAddressByStudentID(int studentId);
	 
	 Address updateAddressByStudentID(int rollnumber, Address address);
	}
