package com.challenge.touwolf.app.rrhh.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
import com.challenge.touwolf.app.rrhh.dto.response.EmployeesResponse;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;
import com.challenge.touwolf.app.rrhh.repository.EmployeeRepository;
import com.challenge.touwolf.app.rrhh.service.impl.EmployeeServiceImpl;
import com.challenge.touwolf.app.rrhh.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	@Mock
	EmployeeConverter converter;
	@Mock
	EmployeeRepository repository;

	public EmployeeDTO employeeDTO;
	public EmployeeEntity employeeEntity;
	public List<EmployeeEntity> listEmployeeEntity;
	public EmployeesResponse response;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		employeeDTO = TestUtils.buildEmployeeDTO();
		employeeEntity = TestUtils.buildEmployeeEntity();
		listEmployeeEntity = TestUtils.builListEmployeeEntity();
		response = TestUtils.buildEmployeesResponse();
	}

	@DisplayName("Test for save employee")
	@Test
	public void saveEmployee() {

	}

	@DisplayName("Test for save employee")
	@Test
	public void saveEmployeeTest() {

		doReturn(employeeEntity).when(converter).dtoToEntity(employeeDTO);
		doNothing().when(repository).saveEmployee(employeeEntity.getName(), employeeEntity.getEmail(),
				employeeEntity.getCity(), employeeEntity.getZipcode(), employeeEntity.getSalary());

		employeeServiceImpl.saveEmployee(employeeDTO);

		verify(converter, times(1)).dtoToEntity(employeeDTO);
		verify(repository, times(1)).saveEmployee(employeeEntity.getName(), employeeEntity.getEmail(),
				employeeEntity.getCity(), employeeEntity.getZipcode(), employeeEntity.getSalary());
	}

	@DisplayName("Test for get Employee By Id")
	@Test
	public void getEmployeeByIdTest() {

		doReturn(Optional.of(employeeEntity)).when(repository).findById(1L);
		doReturn(employeeDTO).when(converter).entityToDTO(employeeEntity);

		var result = employeeServiceImpl.getEmployeeById("1");

		assertNotNull(result);
		assertThat(result.getName()).isEqualTo("testNameEmployee");
	}

	@DisplayName("Test for update employee by id")
	@Test
	public void updateEmployeeByIdTest() {

		EmployeeEntity outdated = EmployeeEntity.builder().id(1L).name("nameOutdated").email("emailOutdated")
				.city("cityOutdated").zipcode("zipcodeOutdated").salary(new BigDecimal("123")).build();

		doReturn(Optional.of(outdated)).when(repository).findById(1L);
		doReturn(outdated).when(repository).save(outdated);
		doReturn(employeeDTO).when(converter).entityToDTO(employeeEntity);

		var result = employeeServiceImpl.updateEmployeeById("1", employeeDTO);

		assertThat(result.getName()).isEqualTo("testNameEmployee");
		assertThat(result.getEmail()).isEqualTo("testEmailEmployee");
	}

	@DisplayName("Test for delete employee by id")
	@Test
	public void deleteEmployeeByIdTest() {

		doReturn(Optional.of(employeeEntity)).when(repository).findById(1L);
		doNothing().when(repository).delete(employeeEntity);

		employeeServiceImpl.deleteEmployeeById("1");

		verify(repository, times(1)).delete(employeeEntity);
	}

}
