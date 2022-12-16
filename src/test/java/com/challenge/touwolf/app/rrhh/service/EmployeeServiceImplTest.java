package com.challenge.touwolf.app.rrhh.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.touwolf.app.rrhh.converter.EmployeeConverter;
import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;
import com.challenge.touwolf.app.rrhh.service.impl.EmployeeServiceImpl;
import com.challenge.touwolf.app.rrhh.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeConverter converter;

	public EmployeeDTO employeeDTO;
	public EmployeeEntity employeeEntity;
	
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		employeeDTO = TestUtils.buildEmployeeDTO();
		employeeEntity = TestUtils.buildEmployeeEntity();
	}
	
	@DisplayName("Test for employee registration")
	@Test
	public void employeeRegistrationTest() {
		
	}

}
