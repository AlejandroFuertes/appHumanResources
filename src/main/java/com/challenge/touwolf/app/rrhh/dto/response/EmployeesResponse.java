package com.challenge.touwolf.app.rrhh.dto.response;

import java.util.List;

import com.challenge.touwolf.app.rrhh.dto.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesResponse {

	@JsonProperty("employees")
	private List<EmployeeDTO> employees;
}
