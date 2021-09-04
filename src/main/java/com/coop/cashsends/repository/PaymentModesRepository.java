package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.PaymentModes;


public interface PaymentModesRepository extends CrudRepository<PaymentModes, Integer> {

	@Query("SELECT p FROM PaymentModes p WHERE p.CountryIsoCode = :countryIsoCode and p.CityId =:cityId and p.status =:status")
	List<PaymentModes> getPaymentModes(String countryIsoCode, Integer cityId, boolean status);

}
