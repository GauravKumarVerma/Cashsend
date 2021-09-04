package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.model.Payer;

public interface PayerRepository extends CrudRepository<Payer, Integer> {

	@Query("SELECT p FROM Payer p WHERE p.CountryIsoCode = :countryIsoCode and p.CityId =:cityId and p.PaymentModeId =:paymentModeId"
			+ " and p.RecieverCurrencyIsoCode =:recieverCurrencyIsoCode and p.SourceCurrencyIsoCode =:senderCurrencyIsoCode and p.status =:status")
	List<Payer> getpayers(String countryIsoCode, Integer cityId, String paymentModeId,
			String recieverCurrencyIsoCode, String senderCurrencyIsoCode,boolean status);

		@Query("SELECT p FROM Payer p WHERE p.CountryIsoCode = :countryIsoCode and p.CityId =:cityId and p.PaymentModeId =:paymentModeId"
			+ " and p.RecieverCurrencyIsoCode =:recieverCurrencyIsoCode and p.SourceCurrencyIsoCode =:senderCurrencyIsoCode and p.status =:status and p.TownId =:TownId")
	List<Payer> getpayerbyTown(String countryIsoCode, Integer cityId, String paymentModeId,
			String recieverCurrencyIsoCode, String senderCurrencyIsoCode,boolean status,Integer TownId);

}
