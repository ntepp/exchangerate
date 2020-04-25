package com.exchangerates.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exchangerates.entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
	Transaction findById(long id);
}
