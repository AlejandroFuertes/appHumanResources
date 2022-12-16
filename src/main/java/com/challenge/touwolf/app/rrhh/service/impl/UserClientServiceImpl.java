package com.challenge.touwolf.app.rrhh.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.touwolf.app.rrhh.client.UserClient;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.dto.response.UsersResponse;
import com.challenge.touwolf.app.rrhh.service.UserClientService;

@Service
public class UserClientServiceImpl implements UserClientService {

	private static final Logger log = LogManager.getLogger(UserClientServiceImpl.class);
	
	@Autowired
	private UserClient userClient;

	public UserDTO getUserById(long id) {

		log.info("Se ingreso al servicio getUserById.");
		UserDTO userResponse = userClient.getUser(id);
		log.info("Se obtuvo la siguiente respuesta de la consulta: " + userResponse.toString());
		return userResponse;
	}

	public UsersResponse getAllUsers() {
		
		log.info("Se ingreso al servicio getAllUsers.");
		List<UserDTO> users = userClient.getUsers();
		UsersResponse usersResponse = new UsersResponse();
		usersResponse.setUsers(users);
		return usersResponse;
	}
}
