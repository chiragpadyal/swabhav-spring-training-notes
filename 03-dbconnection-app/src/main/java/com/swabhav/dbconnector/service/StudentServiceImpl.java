package com.swabhav.dbconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.dbconnector.entities.Student;
import com.swabhav.dbconnector.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudents();
	}

	@Override
	public Student getStudent(int rollnumber) {
		// TODO Auto-generated method stub
		return studentRepository.getStudent(rollnumber);
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.addStudent(student);
		
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentsByName(name);
	}

	@Override
	public void deleteStudent(int rollnumber) {
		// TODO Auto-generated method stub
		studentRepository.deleteStudent(rollnumber);
	}

}
