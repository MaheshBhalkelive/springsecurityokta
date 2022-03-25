package com.yash.springsecurityokta.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RoleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(String message) {
		super(message);
	}
	
	public RoleNotFoundException(String message, Throwable throwable) {
		super(message,throwable);
	}
	
}
