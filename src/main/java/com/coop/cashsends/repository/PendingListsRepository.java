package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.PendingLists;


public interface PendingListsRepository  extends CrudRepository<PendingLists, Integer>  {

	@Query(value = "select * from pending_lists where receiver_country_iso_code =?1 order by created_date desc", nativeQuery = true)
	List<PendingLists>allPendingList(String countrycode);
	
	@Query("SELECT p from PendingLists p where p.TfPin =:tfpin ")
	PendingLists getByTfPin(String tfpin);

	@Query(value = "select * from pending_lists ", nativeQuery = true)
	List<PendingLists> getPendingLists();
}
