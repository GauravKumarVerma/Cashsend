package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.FormOfPayments;

public interface FormOfPaymentsRepository  extends CrudRepository<FormOfPayments, Integer> {

	@Query("SELECT p FROM FormOfPayments p WHERE p.status = :status")
	List<FormOfPayments> getactiveformsofpayments(boolean status);

}
