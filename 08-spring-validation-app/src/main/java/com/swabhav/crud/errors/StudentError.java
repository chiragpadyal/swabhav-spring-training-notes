package com.swabhav.crud.errors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentError {
	private int statusCode;
	private String message;
	private Date timestamp;
}
