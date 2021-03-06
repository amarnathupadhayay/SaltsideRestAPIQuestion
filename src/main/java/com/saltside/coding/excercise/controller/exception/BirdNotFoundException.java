package com.saltside.coding.excercise.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Requested object is missing")
public class BirdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
