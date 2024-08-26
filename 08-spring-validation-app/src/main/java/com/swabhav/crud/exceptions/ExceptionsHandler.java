package com.swabhav.crud.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.swabhav.crud.errors.Field;
import com.swabhav.crud.errors.FieldError;
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
	
	@ExceptionHandler
	public ResponseEntity<FieldError> methodArgsException(MethodArgumentNotValidException e){
		FieldError fieldError = new FieldError();
	    List<Field> fields = new ArrayList<>();
	    e.getBindingResult().getFieldErrors().forEach(
	    			error -> {
	    				fields.add(new Field(error.getField(), error.getDefaultMessage()));
	    			}
	    		);
	    fieldError.setMessage(
	    			fields
	    		);
	    fieldError.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    fieldError.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldError);
	}
	
}
