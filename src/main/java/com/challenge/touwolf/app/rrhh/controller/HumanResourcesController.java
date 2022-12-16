package com.challenge.touwolf.app.rrhh.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.response.EmployeesResponse;
import com.challenge.touwolf.app.rrhh.service.EmployeeService;


/**
 * Controlador que permite guardar, leer, actualizar y eliminar empleados de la base de datos.
 * 
 * @author Alejandro Fuertes
 *
 */
@RestController
@RequestMapping(path = "/api/employee")
public class HumanResourcesController {

	private static final Logger log = LogManager.getLogger(HumanResourcesController.class);

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 
	 * @param employee: Objeto empleado que se guardara en la base de datos
	 * @return codigo http
	 */
	@PostMapping(path = "/registration")
	public ResponseEntity<String> employeeRegistration(@RequestBody EmployeeDTO employee) {
		log.info("Se ingreso al controller employee registration.");
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return Lista actual de empleados
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<EmployeesResponse> getAllEmployees() {
		log.info("Se ingreso al controller getAllEmployees.");
		return new ResponseEntity<EmployeesResponse>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id: hace referencia al id de empleado que se actualizara.
	 * @param employeeDTO: objeto que contiene la informacion a actualizar.
	 * @return Empleado actualizado.
	 */
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable("id") String id,
			@RequestBody EmployeeDTO employeeDTO) {
		log.info("Se ingreso al controller updateEmployeeById.");
		return new ResponseEntity<EmployeeDTO>(employeeService.updateEmployeeById(id, employeeDTO), HttpStatus.OK);
	}

	/**
	 * 
	 * @param id: Id de empleado que se eliminara
	 * @return codigo http.
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") String id) {
		log.info("Se ingreso al controller deleteEmployeeById.");
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id: Id de empleado que se buscara en la base de datos.
	 * @return Objeto empleado que contiene el id solicitado.
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") String id) {
		log.info("Se ingreso al controller getEmployeeById.");
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
}
