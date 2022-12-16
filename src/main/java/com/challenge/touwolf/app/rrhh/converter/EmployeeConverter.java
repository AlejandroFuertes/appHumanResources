package com.challenge.touwolf.app.rrhh.converter;

import org.springframework.stereotype.Component;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;

@Component
public class EmployeeConverter {

	public EmployeeEntity dtoToEntity(EmployeeDTO employeeDTO) {

		return EmployeeEntity.builder().name(employeeDTO.getName()).email(employeeDTO.getEmail())
				.city(employeeDTO.getCity()).salary(employeeDTO.getSalary()).zipcode(employeeDTO.getZipcode())
				.registrationDate(employeeDTO.getRegistrationDate())
				.salaryIncreaseDate(employeeDTO.getSalaryIncreaseDate()).build();
	}

	public EmployeeDTO entityToDTO(EmployeeEntity employeeEntity) {
		return EmployeeDTO.builder().name(employeeEntity.getName()).email(employeeEntity.getEmail())
				.city(employeeEntity.getCity()).zipcode(employeeEntity.getZipcode()).salary(employeeEntity.getSalary())
				.registrationDate(employeeEntity.getRegistrationDate())
				.salaryIncreaseDate(employeeEntity.getSalaryIncreaseDate()).build();
	}
}
