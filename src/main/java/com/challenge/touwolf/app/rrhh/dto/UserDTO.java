package com.challenge.touwolf.app.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private long id;
	private String name;
	private String username;
	private String email;
	private AddressDTO address;
	private String phone;
	private String website;
	private CompanyDTO company;
}
