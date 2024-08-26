package com.swabhav.bank.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	@Column(name = "instructor_name")
	private String name;
	@Column(name = "instructor_email")
	private String email;
	@Column(name = "instructor_qualification")
	private String qualification;
	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
	private List<Course> courses;
}
