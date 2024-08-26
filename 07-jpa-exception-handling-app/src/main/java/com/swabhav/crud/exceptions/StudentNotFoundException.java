package com.swabhav.crud.exceptions;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Student Not found";
	}
	
}
