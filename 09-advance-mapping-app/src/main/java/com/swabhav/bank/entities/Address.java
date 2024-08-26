package com.swabhav.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name = "building_name")
	private String buildingName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private Long pincode;
}
