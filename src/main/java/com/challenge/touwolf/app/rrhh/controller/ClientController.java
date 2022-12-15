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
import com.challenge.touwolf.app.rrhh.service.UserClientService;

@RestController
@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

	@Autowired
	private UserClientService userClientService;

	@GetMapping(path = "/user/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<UserDTO>(userClientService.getUserById(id), HttpStatus.OK);
	}
}
