package com.coop.cashsends.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.dto.ServicefeesDto;
import com.coop.cashsends.model.Servicefees;


public interface ServicefeesRepository extends CrudRepository<Servicefees, Integer>{

	
	@Query(value="SELECT * from service_fees where partner_type= ?1 and transaction_type= ?2 and payment_mode=?3 and sender_country =?4 and reciever_country =?5 and currency_code =?6 and (?7 between start_range and end_range) ",nativeQuery=true)
	Servicefees searchByParams(String partnertype, String transactiontype, String paymentmode, String sendercountry,
			String recievercountry, String currencycode, float amount);

}
