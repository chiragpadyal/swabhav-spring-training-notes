package com.swabhav.crud.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.swabhav.crud.errors.StudentError;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentError> studentNotFoundException(StudentNotFoundException e){
		StudentError studentError = new StudentError();
		studentError.setMessage(e.getMessage());
		studentError.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentError.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentError);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentError> studentArgException(MethodArgumentTypeMismatchException e){
		StudentError studentError = new StudentError();
		studentError.setMessage("id should be int");
		studentError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		studentError.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentError);
	}
	
}
