package com.challenge.touwolf.app.rrhh.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3731855699322167561L;

	private HttpStatus status;

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
}
