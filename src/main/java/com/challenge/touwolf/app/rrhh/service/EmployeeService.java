package com.challenge.touwolf.app.rrhh.service;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.response.EmployeesResponse;

public interface EmployeeService {

	void saveEmployee(EmployeeDTO employeeDTO);
	
	EmployeesResponse getAllEmployee();

	EmployeeDTO updateEmployeeById(String id, EmployeeDTO employeeDTO);

	void deleteEmployeeById(String id);

	EmployeeDTO getEmployeeById(String id);
	
}
