package com.challenge.touwolf.app.rrhh.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentPerson {

	@Column(name = "docnumber", nullable = false)
	private Long docnumber;
	@Column(name = "doctype", nullable = false)
	private String doctype;
}
