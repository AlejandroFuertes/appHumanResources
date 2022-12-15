package com.challenge.touwolf.app.rrhh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.touwolf.app.rrhh.client.UserClient;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.service.UserClientService;

@Service
public class UserClientServiceImpl implements UserClientService{

	@Autowired
	private UserClient userClient;
	
	public UserDTO getUserById(long id) {
		
		UserDTO userResponse = userClient.getUser(id);
		return userResponse;
	}
	
}
