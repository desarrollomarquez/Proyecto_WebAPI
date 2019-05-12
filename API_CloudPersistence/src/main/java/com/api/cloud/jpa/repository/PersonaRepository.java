package com.api.cloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.cloud.jpa.model.Persona;

/**
 * Created by diego on 14/02/19.
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	 @Procedure(name = "java_procedure_name")
	 String procedureName(@Param("inputParam1") String inputParam1, @Param("inputParam2") String inputParam2);
}
