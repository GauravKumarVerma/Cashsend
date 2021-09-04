package com.coop.cashsends.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coop.cashsends.model.TransfastRouter;

@Repository
public interface TransfastRoutersRepository   extends CrudRepository<TransfastRouter, Integer>{
	
	@Query("SELECT p FROM TransfastRouter p WHERE p.sourcetype = :sourcetype")
	TransfastRouter findBySourceType(String sourcetype);

}
