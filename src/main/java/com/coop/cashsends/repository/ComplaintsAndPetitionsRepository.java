package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.ComplaintsAndPetitions;

public interface ComplaintsAndPetitionsRepository extends CrudRepository<ComplaintsAndPetitions, Integer> {

	@Query("SELECT p FROM ComplaintsAndPetitions p WHERE p.status = :status")
	List<ComplaintsAndPetitions> findActivePetitions(boolean status);

}
