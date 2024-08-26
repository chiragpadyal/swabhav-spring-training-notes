package com.swabhav.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.swabhav.crud.dto.PageResponse;
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
		if (student.isPresent())
			return student.get();
		return null;
	}

	@Override
	public Page<Student> findSimilarStudent(Student student, int pageSize, int pageNo) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		return studentRepository.findByRollnumberOrNameOrAge(student.getRollnumber(), student.getName(),
				student.getAge(), page);
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int rollnumber) {
		Optional<Student> student = studentRepository.findById(rollnumber);
		if (student.isPresent())
			studentRepository.delete(student.get());
	}

	@Override
	public void updateStudent(Student student) {
		Optional<Student> isExistStudent = studentRepository.findById(student.getRollnumber());
		if (isExistStudent.isPresent())
			studentRepository.save(student);
	}

	@Override
	public PageResponse<Student> getAllStudentByPage(int pageSize, int pageNo) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		Page<Student> studentPage = studentRepository.findAll(page);
		PageResponse<Student> studentPageResponse = new PageResponse<Student>();
		studentPageResponse.setTotalPages(studentPage.getTotalPages());
		studentPageResponse.setSize(studentPage.getSize());
		studentPageResponse.setTotalElements(studentPage.getTotalElements());
		studentPageResponse.setContent(studentPage.getContent());
		studentPageResponse.setLastPage(studentPage.isLast());

		return studentPageResponse;
	}

}
