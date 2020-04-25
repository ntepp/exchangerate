package com.exchangerates.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exchangerates.entities.Transaction;
import com.exchangerates.services.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService rateService;
	@PostMapping("/transaction")
	ResponseEntity<Transaction> addTransaction( @RequestBody Transaction transaction, HttpServletRequest request) {
		transaction.setIp(request.getRemoteAddr());
		return  new ResponseEntity<>(rateService.getRate(transaction), HttpStatus.OK);
		
    }
	
	
	@PutMapping("/transaction")
    void putTransaction(@RequestBody Transaction transaction) {
       
    }
}
