package com.test.bean;

public class CurrencyExchange {

	private int euro;

	private int inr;

	public int getEuro() {
		return euro;
	}

	public void setEuro(int euro) {
		this.euro = euro;
	}

	public int getInr() {
		return inr;
	}

	public void setInr(int inr) {
		this.inr = inr;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [euro=" + euro + ", inr=" + inr + "]";
	}

	public CurrencyExchange() {

	}

}
