package com.swabhav.crud.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.swabhav.crud.entities.Student;
import com.swabhav.crud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int rollnumber) {
		Optional<Student> student = studentRepository.findById(rollnumber);
		if(student.isPresent()) return student.get();
		return null;
	}

	@Override
	public List<Student> findSimilarStudent(Student student) {
		return studentRepository.findByRollnumberOrNameOrAge(student.getRollnumber(), student.getName(), student.getAge());
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int rollnumber) {
		Optional<Student> student = studentRepository.findById(rollnumber);
		if(student.isPresent()) studentRepository.delete(student.get());
	}

	@Override
	public void updateStudent(Student student) {
		Optional<Student> isExistStudent = studentRepository.findById(student.getRollnumber());
		if(isExistStudent.isPresent()) studentRepository.save(student);
	}
	

}
