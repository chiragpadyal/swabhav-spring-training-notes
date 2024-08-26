package com.swabhav.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Address;
import com.swabhav.bank.entities.Student;
import com.swabhav.bank.repositories.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int rollnumber) {
		Student output = new Student();
		Optional<Student> student = studentRepository.findById(rollnumber);
		if (student.isPresent())
			output = student.get();
		return output;
	}

	@Override
	public Address getAddressByStudentID(int studentId) {
		Optional<Student> isExistStudent = studentRepository.findById(studentId);
		if (isExistStudent.isPresent())
		{
			Student student = isExistStudent.get();
			return student.getAddress();
		}
		return null;
		
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
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
	public Address updateAddressByStudentID(int rollnumber, Address address) {
		Optional<Student> isExistStudent = studentRepository.findById(rollnumber);
		if (isExistStudent.isPresent())
		{
			Student student = isExistStudent.get();
			Address oldAddress = student.getAddress();
			address.setAddressId(oldAddress.getAddressId());
			if(address.getBuildingName() == null) address.setBuildingName(oldAddress.getBuildingName());
			if(address.getCity() == null) address.setCity(oldAddress.getCity());
			if(address.getPincode() == null) address.setPincode(oldAddress.getPincode());
			student.setAddress(address);
			studentRepository.save(student);
			return address;
		}
		return null;
		
	}



}
