package com.coop.cashsends.repository;

import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.TransactionHistory;

public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> { 

}
