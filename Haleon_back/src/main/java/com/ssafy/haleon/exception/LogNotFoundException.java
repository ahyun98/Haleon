package com.ssafy.haleon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LogNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LogNotFoundException(String msg) {
		super(msg);
	}
	
}