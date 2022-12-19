package com.challenge.touwolf.app.rrhh.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.challenge.touwolf.app.rrhh.dto.AddressDTO;
import com.challenge.touwolf.app.rrhh.dto.CompanyDTO;
import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.challenge.touwolf.app.rrhh.dto.LocationDTO;
import com.challenge.touwolf.app.rrhh.dto.UserDTO;
import com.challenge.touwolf.app.rrhh.dto.response.EmployeesResponse;
import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;

public final class TestUtils {

	public static final String NAME_EMPLOYEE = "testNameEmployee";
	public static final String EMAIL_EMPLOYEE = "testEmailEmployee";
	public static final String CITY_EMPLOYEE = "testCityEmployee";
	public static final String ZIPCODE_EMPLOYEE = "testZipcodeEmployee";
	public static final BigDecimal SALARY_EMPLOYEE = new BigDecimal("123456.78");

	public static final long ID = 1L;
	public static final String NAME_CLIENT = "testClient";
	public static final String USERNAME_CLIENT = "usernameClient";
	public static final String EMAIL_CLIENT = "testEmailClient";

	public static final String ADDRESS_CLIENT_STREET = "testAddressClientStreet";
	public static final String ADDRESS_CLIENT_SUITE = "testAddressClientSuite";
	public static final String ADDRESS_CLIENT_CITY = "testAddressClientCity";
	public static final String ADDRESS_CLIENT_ZIPCODE = "testAddressClientZipcode";
	public static final String ADDRESS_CLIENT_LOCATION_LAT = "testAddressClientLocationLat";
	public static final String ADDRESS_CLIENT_LOCATION_LNG = "testAddressClientLocationLng";
	public static final String PHONE_CLIENT = "testPhoneClient";
	public static final String WEBSITE_CLIENT = "testWebsiteClient";

	public static final String COMPANY_CLIENT_NAME = "testCompanyClientName";
	public static final String COMPANY_CLIENT_CATCHPHRASE = "testCompanyClientPhrase";
	public static final String COMPANY_CLIENT_BS = "testCompanyClientBs";

	public static EmployeeDTO buildEmployeeDTO() {

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(NAME_EMPLOYEE);
		employee.setEmail(EMAIL_EMPLOYEE);
		employee.setCity(CITY_EMPLOYEE);
		employee.setZipcode(ZIPCODE_EMPLOYEE);
		employee.setSalary(SALARY_EMPLOYEE);
		return employee;
	}

	public static EmployeeEntity buildEmployeeEntity() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(ID);
		entity.setName(NAME_EMPLOYEE);
		entity.setEmail(EMAIL_EMPLOYEE);
		entity.setCity(CITY_EMPLOYEE);
		entity.setZipcode(ZIPCODE_EMPLOYEE);
		entity.setSalary(SALARY_EMPLOYEE);
		return entity;
	}

	public static UserDTO buildUserDTO() {
		UserDTO userDTO = new UserDTO();
		AddressDTO addressDTO = new AddressDTO();
		CompanyDTO companyDTO = new CompanyDTO();
		LocationDTO locationDTO = new LocationDTO();

		companyDTO.setName(COMPANY_CLIENT_NAME);
		companyDTO.setCatchPhrase(COMPANY_CLIENT_CATCHPHRASE);
		companyDTO.setBs(COMPANY_CLIENT_BS);

		locationDTO.setLat(ADDRESS_CLIENT_LOCATION_LAT);
		locationDTO.setLng(ADDRESS_CLIENT_LOCATION_LNG);

		addressDTO.setStreet(ADDRESS_CLIENT_STREET);
		addressDTO.setCity(ADDRESS_CLIENT_CITY);
		addressDTO.setSuite(ADDRESS_CLIENT_SUITE);
		addressDTO.setGeo(locationDTO);
		addressDTO.setZipcode(ADDRESS_CLIENT_ZIPCODE);

		userDTO.setId(ID);
		userDTO.setName(NAME_CLIENT);
		userDTO.setEmail(EMAIL_CLIENT);
		userDTO.setUsername(USERNAME_CLIENT);
		userDTO.setPhone(PHONE_CLIENT);
		userDTO.setWebsite(WEBSITE_CLIENT);
		userDTO.setAddress(addressDTO);
		userDTO.setCompany(companyDTO);

		return userDTO;
	}

	public static List<UserDTO> buildListUsersDTO() {
		List<UserDTO> users = new ArrayList<>();
		
		UserDTO userDTO = new UserDTO();
		AddressDTO addressDTO = new AddressDTO();
		CompanyDTO companyDTO = new CompanyDTO();
		LocationDTO locationDTO = new LocationDTO();

		companyDTO.setName(COMPANY_CLIENT_NAME);
		companyDTO.setCatchPhrase(COMPANY_CLIENT_CATCHPHRASE);
		companyDTO.setBs(COMPANY_CLIENT_BS);

		locationDTO.setLat(ADDRESS_CLIENT_LOCATION_LAT);
		locationDTO.setLng(ADDRESS_CLIENT_LOCATION_LNG);

		addressDTO.setStreet(ADDRESS_CLIENT_STREET);
		addressDTO.setCity(ADDRESS_CLIENT_CITY);
		addressDTO.setSuite(ADDRESS_CLIENT_SUITE);
		addressDTO.setGeo(locationDTO);
		addressDTO.setZipcode(ADDRESS_CLIENT_ZIPCODE);

		userDTO.setId(ID);
		userDTO.setName(NAME_CLIENT);
		userDTO.setEmail(EMAIL_CLIENT);
		userDTO.setUsername(USERNAME_CLIENT);
		userDTO.setPhone(PHONE_CLIENT);
		userDTO.setWebsite(WEBSITE_CLIENT);
		userDTO.setAddress(addressDTO);
		userDTO.setCompany(companyDTO);
		
		users.add(userDTO);	
		return users;
	}

	public static List<EmployeeEntity> builListEmployeeEntity() {
		List<EmployeeEntity> entities = new ArrayList<>();
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setId(ID);
		entity.setName(NAME_EMPLOYEE);
		entity.setEmail(EMAIL_EMPLOYEE);
		entity.setCity(CITY_EMPLOYEE);
		entity.setZipcode(ZIPCODE_EMPLOYEE);
		entity.setSalary(SALARY_EMPLOYEE);
		
		entities.add(entity);
		return entities;
	}

	public static EmployeesResponse buildEmployeesResponse() {
		List<EmployeeDTO> dto = new ArrayList<>();
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(NAME_EMPLOYEE);
		employee.setEmail(EMAIL_EMPLOYEE);
		employee.setCity(CITY_EMPLOYEE);
		employee.setZipcode(ZIPCODE_EMPLOYEE);
		employee.setSalary(SALARY_EMPLOYEE);
		
		dto.add(employee);
		
		EmployeesResponse response = new EmployeesResponse();
		response.setEmployees(dto);
		return response;
	}
}
