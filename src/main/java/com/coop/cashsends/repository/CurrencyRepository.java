package com.coop.cashsends.repository;

import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

}
