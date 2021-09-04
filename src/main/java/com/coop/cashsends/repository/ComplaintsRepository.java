package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.Complaints;

public interface ComplaintsRepository  extends CrudRepository<Complaints, Integer>  {
	
	@Query("SELECT p FROM Complaints p WHERE  p.status =:status")
	 List<Complaints> getActiveComplaints(boolean status);	
	

}
