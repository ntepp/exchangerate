package com.exchangerates.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exchangerates.entities.Transaction;
import com.exchangerates.repositories.RedisRateRepository;
import com.exchangerates.repositories.TransactionRepository;
import com.exchangerates.utility.ExchangeStatic;

@Service
public class TransactionService {
	Logger logger = LoggerFactory.getLogger(TransactionService.class);
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	private RedisRateRepository redisRepository;

	public Transaction getRate(Transaction tr) {
		logger.info("rate {}", tr);
		String rFromApi = null;
		String apiUrl = ExchangeStatic.apiUrl + tr.getBaseCurrency();
		ResponseEntity<String> response = null;

		String key = tr.getBaseCurrency();
		rFromApi = redisRepository.findById(key);
		logger.info("exchangeratesapi.io response {}", rFromApi);
		if (Objects.isNull(rFromApi)) {
			response = restTemplate.getForEntity(apiUrl, String.class);
			rFromApi = response.getBody().toString();
			redisRepository.save(key, rFromApi);
		}

		JSONObject resultJ = new JSONObject(rFromApi);
		BigDecimal baseAmounExch = new BigDecimal(1.0);
		BigDecimal targetAmounExch = resultJ.getJSONObject("rates").getBigDecimal(tr.getTargetCurrency());
		tr.setExchangeRate(targetAmounExch.divide(baseAmounExch, 5, RoundingMode.HALF_UP));
		tr.setTargetAmount(tr.getExchangeRate().multiply(tr.getBaseAmount()));
		tr.setDate(new Date());

		transactionRepository.save(tr);

		return tr;
	}

	public List<Transaction> getAll() {
		List<Transaction> transactionL = new ArrayList<Transaction>();
		transactionRepository.findAll().iterator().forEachRemaining(transactionL::add);
		return transactionL;
	}
}
