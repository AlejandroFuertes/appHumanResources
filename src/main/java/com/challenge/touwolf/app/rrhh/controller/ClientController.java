package com.challenge.touwolf.app.rrhh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.dto.response.UsersResponse;
import com.challenge.touwolf.app.rrhh.service.UserClientService;

/**
 * Controlador que permite ver uno o mas aspirantes para la empresa.
 * @author Alejandro Fuertes
 *
 */
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

	@Autowired
	private UserClientService userClientService;

	/**
	 * 
	 * @param id: Id de usuario que desea consultar
	 * @return UserDTO: Objeto que contiene toda la informacion del usuario con el id solicitado.
	 */
	@GetMapping(path = "/employment/application/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<UserDTO>(userClientService.getUserById(id), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return Lista completa de todos los aspirantes.
	 */
	@GetMapping(path = "/employment/application")
	public ResponseEntity<UsersResponse> employmentApplication() {
		return new ResponseEntity<UsersResponse>(userClientService.getAllUsers(), HttpStatus.OK);
	}
}
