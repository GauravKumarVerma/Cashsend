package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.ExchangeRates;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRates, Integer> {
	
	@Query("SELECT p FROM ExchangeRates p WHERE  p.SourceCurrencyCode =:sourceCurrency and p.RecieverCurrencyCode= :recieverCurrency and p.status =:status")
	List<ExchangeRates> getExchangeRates(String sourceCurrency,String recieverCurrency, boolean status);	

}
