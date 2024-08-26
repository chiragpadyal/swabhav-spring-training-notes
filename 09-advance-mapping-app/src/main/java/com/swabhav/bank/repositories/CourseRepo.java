package com.swabhav.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Course;
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{
	
}
