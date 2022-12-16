package com.challenge.touwolf.app.rrhh.errorhandler;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.touwolf.app.rrhh.exception.DatabaseException;
import com.challenge.touwolf.app.rrhh.exception.RequestException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(RequestException.class)
	public ResponseEntity<ApiError> methodArgumentNotValidException(RequestException ex) {
		ApiError error = ApiError.builder().message(ex.getMessage()).timestamp(LocalDateTime.now()).build();
		return new ResponseEntity<>(error, ex.getStatus());
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ApiError> databaseNotFoundException(DatabaseException ex) {
		ApiError error = ApiError.builder().message(ex.getMessage()).timestamp(LocalDateTime.now()).build();
		return new ResponseEntity<>(error, ex.getStatus());
	}
}
