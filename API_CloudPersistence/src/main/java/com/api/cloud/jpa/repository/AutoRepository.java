package com.api.cloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cloud.jpa.model.Auto;

/**
 * Created by diego on 14/02/19.
 */

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {

}
