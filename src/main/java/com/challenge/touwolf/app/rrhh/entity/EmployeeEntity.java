package com.challenge.touwolf.app.rrhh.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "zipcode", nullable = false)
	private String zipcode;
	@Column(name = "salary", nullable = false)
	private BigDecimal salary;
	@Column(name = "registration_date", nullable = true)
	private LocalDateTime registrationDate;
	@Column(name = "salary_increase_date", nullable = true)
	private LocalDateTime salaryIncreaseDate;
}
