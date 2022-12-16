package com.challenge.touwolf.app.rrhh.service;

import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.dto.response.UsersResponse;

public interface UserClientService {

	UserDTO getUserById(long id);
	
	UsersResponse getAllUsers();
}
