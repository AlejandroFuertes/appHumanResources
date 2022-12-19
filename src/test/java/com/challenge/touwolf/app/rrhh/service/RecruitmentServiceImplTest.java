package com.challenge.touwolf.app.rrhh.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.touwolf.app.rrhh.converter.EmployeeConverter;
import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.service.impl.RecruitmentServiceImpl;
import com.challenge.touwolf.app.rrhh.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class RecruitmentServiceImplTest {

	@InjectMocks
	RecruitmentServiceImpl recruitmentServiceImpl;
	@Mock
	UserClientService userClientService;
	@Mock
	EmployeeService employeeService;
	@Mock
	EmployeeConverter converter;

	public UserDTO userDTO;
	public EmployeeDTO employeeDTO;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		userDTO = TestUtils.buildUserDTO();
		employeeDTO = TestUtils.buildEmployeeDTO();
	}

	@DisplayName("Test for recruit by id")
	@Test
	public void recruitByIdTest() {

		doReturn(userDTO).when(userClientService).getUserById(1L);

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(userDTO.getName());
		employee.setEmail(userDTO.getEmail());
		employee.setCity(userDTO.getAddress().getCity());
		employee.setZipcode(userDTO.getAddress().getZipcode());
		employee.setSalary(new BigDecimal("123456.78"));
		doNothing().when(employeeService).saveEmployee(employee);

		recruitmentServiceImpl.recruitById("1", "123456.78");

		verify(userClientService, times(1)).getUserById(1L);
	}
}
