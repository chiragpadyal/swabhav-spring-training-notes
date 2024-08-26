package com.swabhav.crud.dto;

import com.swabhav.bank.entities.Course;

import lombok.Data;

@Data
public class CourseDto {
	private int courseId;
	private String courseName;
	private int duration;
	private double fees;
	
	public CourseDto toDto(Course course) {
		this.setCourseId(course.getCourseId());
		this.setCourseName(course.getCourseName());
		this.setFees(course.getFees());
		this.setDuration(course.getDuration());
		return this;
	}
	
	public Course toCourse() {
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setDuration(duration);
		course.setFees(fees);
		return course;
	}
}
