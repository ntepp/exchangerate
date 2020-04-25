package com.exchangerates.utility;

import java.util.HashMap;

public interface ExchangeStatic {
	String BASE = "EUR";
	String apiUrl = "https://api.exchangeratesapi.io/latest?base=";
	String REDIS_KEY = "RATE";
	
	HashMap<String, String> currencies = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;

	{
		put("Australian Dollar", "AUD");
		put("Brazilian Real", "BRL");
		put("British Pound Sterline", "GBP");
		put("Bulgarian Lev", "BGN");
		put("Canadian Dollar", "CAD");
		put("Chinese Yuan Renminbi", "CNY");
		put("Croatian Kuna", "HRK");
		put("Czech Koruna", "CZK");
		put("Danish Krone", "DKK");
		put("Euro", "EUR");
		put("Hong Kong Dollar", "HKD");
		put("Hungarian Forint", "HUF");
		put("Icelandic Krona", "ISK");
		put("Indonesian Rupiah", "IDR");
		put("Indian Rupee", "INR");
		put("Israeli Shekel", "ILS");
		put("Japanese Yen", "JPY");
		put("Malaysian Ringgit", "MYR");
		put("Mexican Peso", "MXN");
		put("New Zealand Dollar", "NZD");
		put("Norwegian Krone", "NOK");
		put("Philippine Peso", "PHP");
		put("Polish Zloty", "PLN");
		put("Romanian Leu", "RON");
		put("Russian Rouble", "RUB");
		put("Singapore Dollar", "SGD");
		put("South African Rand", "ZAR");
		put("South Korean Won", "KRW");
		put("Swedish Krona", "SEK");
		put("Swiss Franc", "CHF");
		put("Thai Baht", "THB");
		put("Turkish Lira", "TRY");
		put("US Dollar", "USD");
	}};
	
	
	
}
