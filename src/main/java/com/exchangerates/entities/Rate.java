package com.exchangerates.entities;

import java.math.BigDecimal;

public class Rate {
	private BigDecimal baseAmount;
	private BigDecimal targetAmount;
	private String baseCurrency;
	private String targetCurrency;
	/**
	 * @param baseAmount
	 * @param baseCurrency
	 * @param targetCurrency
	 */
	public Rate(BigDecimal baseAmount, String baseCurrency, String targetCurrency) {
		super();
		this.baseAmount = baseAmount;
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rate [baseAmount=" + baseAmount + ", baseCurrency=" + baseCurrency + ", targetCurrency="
				+ targetCurrency + "]";
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
	
	
}
