package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.CancelReason;


public interface CancelReasonRepository extends CrudRepository<CancelReason, Integer> {
	
	@Query("SELECT p FROM CancelReason p WHERE  p.status =:status")
	 List<CancelReason> getActiveCancelReasons(boolean status);	

}
