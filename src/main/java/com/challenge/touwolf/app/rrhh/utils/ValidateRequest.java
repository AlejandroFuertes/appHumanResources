package com.challenge.touwolf.app.rrhh.utils;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.exception.RequestException;

public class ValidateRequest {

	public void validateFields(EmployeeDTO employee) {
		validateName(employee.getName());
		validateEmail(employee.getEmail());
		validateCity(employee.getCity());
		validateZipcode(employee.getZipcode());
		validateSalary(employee.getSalary());
	}

	public void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST, "name is required");
		}
	}

	public void validateEmail(String email) {
		if (email == null || email.isEmpty()) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST, "email is required");
		}
	}

	public void validateCity(String city) {
		if (city == null || city.isEmpty()) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST, "city is required");
		}
	}

	public void validateZipcode(String zipcode) {
		if (zipcode == null || zipcode.isEmpty()) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST, "zipcode is required");
		}
	}

	public void validateSalary(BigDecimal salary) {
		if (salary == null || BigDecimal.ZERO.compareTo(salary) == 0) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST,
					"salary is required and must be greater than zero.");
		}
	}

	public void validateStringIsNumber(String validate) {
		if (!validate.matches("[0-9]+")) {
			throw new RequestException("400", HttpStatus.BAD_REQUEST, "field must be numeric");
		}
	}
}
