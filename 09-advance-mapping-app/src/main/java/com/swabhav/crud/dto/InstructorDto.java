package com.swabhav.crud.dto;

import com.swabhav.bank.entities.Instructor;

import lombok.Data;

@Data
public class InstructorDto {
	private int instructorId;
	private String name;
	private String email;
	private String qualification;
	
	public InstructorDto toDto(Instructor instructor) {
		this.setInstructorId(instructor.getInstructorId());
		this.setName(instructor.getName());
		this.setEmail(instructor.getEmail());
		this.setQualification(instructor.getQualification());
		return this;
	}
	
	public Instructor toInstructor() {
		Instructor instructor = new Instructor();
		instructor.setEmail(email);
		instructor.setInstructorId(instructorId);
		instructor.setName(name);
		instructor.setQualification(qualification);
		return instructor;
	}
}
