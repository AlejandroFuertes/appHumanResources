package com.challenge.touwolf.app.rrhh.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.touwolf.app.rrhh.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "CALL PUBLIC.INSERT_PROC(:name, :email, :city, :zipcode, :salary);")
	public void saveEmployee(@Param("name") String name, @Param("email") String email, @Param("city") String city,
			@Param("zipcode") String zipcode, @Param("salary") BigDecimal salary);
}
