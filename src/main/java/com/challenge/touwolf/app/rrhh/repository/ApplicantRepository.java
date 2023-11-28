package com.challenge.touwolf.app.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.touwolf.app.rrhh.entity.ApplicantEntity;
import com.challenge.touwolf.app.rrhh.entity.DocumentPerson;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, DocumentPerson> {

}
