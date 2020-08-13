package com.exchangerates.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.exchangerates.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	Transaction findById(long id);
}
