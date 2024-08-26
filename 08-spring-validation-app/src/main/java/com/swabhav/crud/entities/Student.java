package com.swabhav.crud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "rollnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;
	
	@Column(name = "age")
	@Min(value = 18, message = "Age must be above 18")
	private int age;
	
	@Column(name = "name")
	@NotBlank(message = "Name can't be blank")
	private String name;
	
}
