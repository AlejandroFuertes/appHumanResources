package com.challenge.touwolf.app.rrhh.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenge.touwolf.app.rrhh.dto.UserDTO;

@FeignClient(name = "jsonPlaceHolder", url = "${jsonplaceholder.url}")
public interface UserClient {

	@GetMapping(path = "/users/{id}")
	UserDTO getUser(@RequestParam(name = "id") long id);
	
	@GetMapping(path = "/users")
	List<UserDTO> getUsers();
}
