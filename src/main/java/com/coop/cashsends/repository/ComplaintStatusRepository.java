package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.ComplaintStatus;


public interface ComplaintStatusRepository  extends CrudRepository<ComplaintStatus, Integer> {

	@Query("SELECT p FROM ComplaintStatus p WHERE  p.currentstatus =:status")
	 List<ComplaintStatus> getnewComplaitStatus(String status);	
	
}
