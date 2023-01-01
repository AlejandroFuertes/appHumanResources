package com.challenge.touwolf.app.rrhh.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "applicants")
public class ApplicantEntity {

	private DocumentPerson document;
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	@Column(name = "lastname", length = 30, nullable = false)
	private String lastname;
	@Column(name = "email", length = 30, nullable = true)
	private String email;
	@Column(name = "address", length = 50, nullable = true)
	private String address;
	@Column(name = "phone", length = 30, nullable = true)
	private Long phone;
	@Column(name = "cv", nullable = false)
	private Blob cv;
}
