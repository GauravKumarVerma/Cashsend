package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.RecieverCurrency;

public interface RecieverCurrencyRepository extends CrudRepository<RecieverCurrency, Integer> {

	@Query("SELECT p FROM RecieverCurrency p WHERE p.CountryIsoCode = :countryIsoCode and p.StateId =:stateId "
			+ "and p.CityId =:cityId and p.PaymentModeId =:paymentModeId and p.status =:status")
	List<RecieverCurrency> getrecieverCurrency(String countryIsoCode, Integer stateId, Integer cityId, String paymentModeId,
			boolean status);

}
