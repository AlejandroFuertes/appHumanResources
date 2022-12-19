package com.challenge.touwolf.app.rrhh.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.touwolf.app.rrhh.client.UserClient;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.service.impl.UserClientServiceImpl;
import com.challenge.touwolf.app.rrhh.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class UserClientServiceImplTest {

	@InjectMocks
	UserClientServiceImpl userClientServiceImpl;

	@Mock
	UserClient userClient;

	public UserDTO userDTO;
	public List<UserDTO> users;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
		userDTO = TestUtils.buildUserDTO();
		users = TestUtils.buildListUsersDTO();
	}

	@DisplayName("Test for get user by id")
	@Test
	public void getUserByIdTest() {

		doReturn(userDTO).when(userClient).getUser(1L);
		var result = userClientServiceImpl.getUserById(1L);
		verify(userClient, times(1)).getUser(1L);

		assertNotNull(result);
		assertEquals(result.getId(), userDTO.getId());
		assertEquals(result.getName(), userDTO.getName());
		assertEquals(result.getAddress(), userDTO.getAddress());
	}

	@DisplayName("Test for get all users")
	@Test
	public void getAllUsersTest() {
		doReturn(users).when(userClient).getUsers();
		var result = userClientServiceImpl.getAllUsers();
		verify(userClient, times(1)).getUsers();

		assertNotNull(result);
		assertEquals(result.getUsers(), users);
		assertThat(result.getUsers().size()).isEqualTo(1);
		assertEquals(result.getUsers().get(0).getName(), users.get(0).getName());
	}
}
