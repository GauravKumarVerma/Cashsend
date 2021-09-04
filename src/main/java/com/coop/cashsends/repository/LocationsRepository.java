package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.coop.cashsends.model.Locations;
import com.coop.cashsends.model.User;

public interface LocationsRepository  extends CrudRepository<Locations, Integer>{
	
	 @Query("SELECT p FROM Locations p WHERE p.partnerid = :partnerid")
	 List<Locations> partnerLocations(Integer partnerid);

	 @Query("SELECT p FROM Locations p WHERE p.BranchId = :payingBranchId")
	Locations getLocationsbyBranchId(String payingBranchId);
	 	

}
