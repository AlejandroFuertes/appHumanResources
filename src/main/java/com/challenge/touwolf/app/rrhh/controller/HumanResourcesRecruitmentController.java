package com.challenge.touwolf.app.rrhh.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.touwolf.app.rrhh.service.RecruitmentService;

/**
 * Controlador que permite realizar contrataciones de acuerdo a la lista de aspirantes.
 * @author Alejandro Fuertes
 *
 */
@RestController
@RequestMapping(path = "/api/recruitment")
public class HumanResourcesRecruitmentController {

	private static final Logger log = LogManager.getLogger(HumanResourcesRecruitmentController.class);

	@Autowired
	private RecruitmentService recruitmentService;

	/**
	 * 
	 * @param idUser: Id que permite filtrar el aspirante a contratar
	 * @param salary: Es el salario que se guardara en la base de datos para el aspirante.
	 * @return String, mensaje de confirmacion.
	 */
	@GetMapping(path = "/recruit")
	public ResponseEntity<String> recruitById(@RequestParam(name = "idUser", required = true) String idUser,
			@RequestParam(name = "salary", required = true) String salary) {
		log.info("Se ingreso al controlador recruit.");

		recruitmentService.recruitById(idUser, salary);

		return ResponseEntity.ok("Contratado Exitosamente");
	}
}
