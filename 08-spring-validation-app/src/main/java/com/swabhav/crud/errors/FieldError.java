package com.swabhav.crud.errors;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldError {
	private int statusCode;
	private List<Field> message;
	private Date timestamp;
}
