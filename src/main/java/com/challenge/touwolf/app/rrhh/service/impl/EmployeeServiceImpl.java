package com.challenge.touwolf.app.rrhh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.touwolf.app.rrhh.converter.EmployeeConverter;
import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.response.EmployeesResponse;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;
import com.challenge.touwolf.app.rrhh.exception.DatabaseException;
import com.challenge.touwolf.app.rrhh.repository.EmployeeRepository;
import com.challenge.touwolf.app.rrhh.service.EmployeeService;
import com.challenge.touwolf.app.rrhh.utils.ValidateRequest;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LogManager.getLogger(EmployeeServiceImpl.class);
	private static final String ERROR_NOT_FOUND = "No se ha encontrado datos para esta peticion.";

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeConverter converter;

	@Override
	public void saveEmployee(EmployeeDTO employee) {

		log.info("Se ingreso a la capa de servicio.");
		validateFields(employee);
		log.info("Campos validados.");
		EmployeeEntity entity = converter.dtoToEntity(employee);
		employeeRepository.saveEmployee(entity.getName(), entity.getEmail(), entity.getCity(), entity.getZipcode(),
				entity.getSalary());
	}

	@Override
	public EmployeesResponse getAllEmployee() {
		log.info("Se ingreso a la capa de servicio.");
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		List<EmployeeDTO> employees = getEmployeesDTO(entityList);
		return EmployeesResponse.builder().employees(employees).build();
	}

	@Override
	public EmployeeDTO updateEmployeeById(String id, EmployeeDTO employeeDTO) {
		log.info("Se ingreso a la capa de servicio.");
		validatePathUrl(id);
		log.info("Campos validados.");
		Long idEmployee = Long.parseLong(id);
		var employeeEntity = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new DatabaseException(HttpStatus.NOT_FOUND, ERROR_NOT_FOUND));

		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setEmail(employeeDTO.getEmail());
		employeeEntity.setCity(employeeDTO.getCity());
		employeeEntity.setZipcode(employeeDTO.getZipcode());
		employeeEntity.setSalary(employeeDTO.getSalary());

		if (employeeDTO.getRegistrationDate() != null) {
			employeeEntity.setRegistrationDate(employeeDTO.getRegistrationDate());
		}
		if (employeeDTO.getSalaryIncreaseDate() != null) {
			employeeEntity.setSalaryIncreaseDate(employeeDTO.getSalaryIncreaseDate());
		}
		employeeRepository.save(employeeEntity);
		return converter.entityToDTO(employeeEntity);
	}

	@Override
	public void deleteEmployeeById(String id) {
		log.info("Se ingreso a la capa de servicio.");
		validatePathUrl(id);
		log.info("Campos validados.");
		Long idEmployee = Long.parseLong(id);
		var employeeEntity = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new DatabaseException(HttpStatus.NOT_FOUND, ERROR_NOT_FOUND));
		employeeRepository.delete(employeeEntity);
	}

	@Override
	public EmployeeDTO getEmployeeById(String id) {
		log.info("Se ingreso a la capa de servicio.");
		validatePathUrl(id);
		log.info("Campos validados.");
		Long idEmployee = Long.parseLong(id);

		var employeeEntity = employeeRepository.findById(idEmployee)
				.orElseThrow(() -> new DatabaseException(HttpStatus.NOT_FOUND, ERROR_NOT_FOUND));

		return converter.entityToDTO(employeeEntity);
	}

	private void validateFields(EmployeeDTO employee) {
		ValidateRequest validate = new ValidateRequest();
		validate.validateFields(employee);
	}

	private void validatePathUrl(String id) {
		ValidateRequest validate = new ValidateRequest();
		validate.validateStringIsNumber(id);
	}

	private List<EmployeeDTO> getEmployeesDTO(List<EmployeeEntity> entities) {
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		EmployeeDTO employee = new EmployeeDTO();
		for (EmployeeEntity employeeEntity : entities) {

			employee = converter.entityToDTO(employeeEntity);
			employees.add(employee);
		}
		return employees;
	}
}
