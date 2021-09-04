package com.coop.cashsends.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coop.cashsends.model.LovType;

@Repository
public interface LovTypesRepository extends CrudRepository<LovType, Integer> {

	 @Query("SELECT p FROM LovType p WHERE p.name = :name")
	 LovType getLovType(String name);
}
