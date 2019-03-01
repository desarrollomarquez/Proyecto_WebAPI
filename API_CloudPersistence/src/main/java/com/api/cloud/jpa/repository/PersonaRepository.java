package com.api.cloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cloud.jpa.model.Persona;

/**
 * Created by diego on 14/02/19.
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
