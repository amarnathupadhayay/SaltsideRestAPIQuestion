package com.saltside.coding.excercise.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Either required field is missing or value is invalid")
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}