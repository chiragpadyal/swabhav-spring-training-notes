package com.swabhav.bank.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "rollnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;

	@Column(name = "age")
	private int age;

	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId")
	@JsonIgnore
	private Address address;
}
