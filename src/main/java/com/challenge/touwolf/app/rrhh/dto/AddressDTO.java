package com.challenge.touwolf.app.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private LocationDTO geo;
}
