package com.challenge.touwolf.app.rrhh.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3322200041765374160L;

	private String code;
	private HttpStatus status;

	public RequestException(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}

	public RequestException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
}
