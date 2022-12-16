package com.challenge.touwolf.app.rrhh.utils;

import java.math.BigDecimal;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;

public final class TestUtils {

	public static final String NAME = "testName";
	public static final String EMAIL = "testEmail";
	public static final String CITY = "testCity";
	public static final String ZIPCODE = "testZipcode";
	public static final BigDecimal SALARY = new BigDecimal("123456.78");

	public static EmployeeDTO buildEmployeeDTO() {

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(NAME);
		employee.setEmail(EMAIL);
		employee.setCity(CITY);
		employee.setZipcode(ZIPCODE);
		employee.setSalary(SALARY);
		return employee;
	}

	public static EmployeeEntity buildEmployeeEntity() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setName(NAME);
		entity.setEmail(EMAIL);
		entity.setCity(CITY);
		entity.setZipcode(ZIPCODE);
		entity.setSalary(SALARY);
		return entity;
	}
}
