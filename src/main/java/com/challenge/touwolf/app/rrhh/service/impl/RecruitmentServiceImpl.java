package com.challenge.touwolf.app.rrhh.service.impl;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.service.EmployeeService;
import com.challenge.touwolf.app.rrhh.service.RecruitmentService;
import com.challenge.touwolf.app.rrhh.service.UserClientService;
import com.challenge.touwolf.app.rrhh.utils.ValidateRequest;

@Service
@Transactional
public class RecruitmentServiceImpl implements RecruitmentService {

	private static final Logger log = LogManager.getLogger(RecruitmentServiceImpl.class);

	@Autowired
	private UserClientService userClientService;
	@Autowired
	private EmployeeService employeeService;

	public void recruitById(String idClient, String salary) {

		log.info("Ingreso a la capa de servicio.");
		validateRequestParam(idClient);
		validateBigDecimalRequestParam(salary);
		Long id = Long.parseLong(idClient);
		BigDecimal salaryDecimal = new BigDecimal(salary);

		/* Buscamos al usuario que queremos contratar mediante el id */
		UserDTO user = userClientService.getUserById(id);

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(user.getName());
		employee.setEmail(user.getEmail());
		employee.setCity(user.getAddress().getCity());
		employee.setZipcode(user.getAddress().getZipcode());
		employee.setSalary(salaryDecimal);

		/* Lo guardamos en nuestra base de datos de empleados. CONTRATADO */
		employeeService.saveEmployee(employee);
	}

	private void validateRequestParam(String id) {
		ValidateRequest validate = new ValidateRequest();
		validate.validateStringIsNumber(id);
	}
	
	private void validateBigDecimalRequestParam(String salary) {
		ValidateRequest validate = new ValidateRequest();
		BigDecimal salaryDecimal = new BigDecimal(salary);
		
		validate.validateSalary(salaryDecimal);
	}
}
