package com.exchangerates.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="transaction")
public class Transaction {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private BigDecimal baseAmount;
	private String baseCurrency;
	private BigDecimal targetAmount;
	private String targetCurrency;
	private BigDecimal exchangeRate;
	private String ip;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the baseAmount
	 */
	public BigDecimal getBaseAmount() {
		return baseAmount;
	}
	/**
	 * @param baseAmount the baseAmount to set
	 */
	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}
	/**
	 * @return the baseCurrency
	 */
	public String getBaseCurrency() {
		return baseCurrency;
	}
	/**
	 * @param baseCurrency the baseCurrency to set
	 */
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	/**
	 * @return the targetAmount
	 */
	public BigDecimal getTargetAmount() {
		return targetAmount;
	}
	/**
	 * @param targetAmount the targetAmount to set
	 */
	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}
	/**
	 * @return the targetCurrency
	 */
	public String getTargetCurrency() {
		return targetCurrency;
	}
	/**
	 * @param targetCurrency the targetCurrency to set
	 */
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	/**
	 * @return the exchangeRate
	 */
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
