package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import com.test.bean.Item;
import com.test.dao.CurrencyDao;


public class MainController {

	public static CurrencyDao dao=null;
	
	public static void insertRecord(String item, double cost) {
				
		try{
			dao= new CurrencyDao();
			System.out.println("calling dao "+ item+" "+ cost);
			dao.insertRecord(item, cost);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	public static List<Item> readRecords() {
		
		List<Item> result= new ArrayList<Item>();
		
		try{
			dao= new CurrencyDao();
			 result= dao.readAllRecords();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
		
	public static double currencyConvertEuro(double usd) {
		
		double rate= 1;
		try {
			dao= new CurrencyDao();
			rate= dao.convertCurrencyEuro(usd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rate;
	}

	public static double currencyConvertInr(double usd) {
		
		double rate= 1;
		try {
			dao= new CurrencyDao();
			rate= dao.convertCurrencyInr(usd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rate;
	}	
	
	
	public static void main(String[] args) {

		
	}

}
