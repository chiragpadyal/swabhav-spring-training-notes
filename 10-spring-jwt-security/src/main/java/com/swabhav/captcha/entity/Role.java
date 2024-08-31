package com.swabhav.captcha.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(unique = true)
	private String name;
	
	@ManyToMany
	@JoinTable(
			  name = "user_role", 
			  joinColumns = @JoinColumn(name = "userId"), 
			  inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<User> users;
}
