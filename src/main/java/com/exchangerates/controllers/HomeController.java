package com.exchangerates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exchangerates.entities.Transaction;
import com.exchangerates.services.TransactionService;
import com.exchangerates.utility.ExchangeStatic;

@Controller
public class HomeController {
	@Autowired
	TransactionService transactionService;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("transactions", transactionService.getAll());
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("currencies", ExchangeStatic.currencies);
		return "home/index";
	}
}
