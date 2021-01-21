package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.bean.Item;

public class CurrencyDao {

	public static Connection con= null;

	
	public static Connection getConnection() {  
				 
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tsys","root","infrared");	
		if (con != null) {
			System.out.println("Database Connected successfully");
		} else {
			System.out.println("Database Connection failed");
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return con;  
	}  
		
	
public List<Item> readAllRecords() {

	List<Item> result= new ArrayList<Item>();

	try {
	con= CurrencyDao.getConnection();	
	PreparedStatement stmt=con.prepareStatement("select * from itemcost");  
	ResultSet rs=stmt.executeQuery();  
	while(rs.next()) {

		Item i1= new Item();
		i1.setItem(rs.getString(2));
		i1.setCost(rs.getDouble(3));
		result.add(i1);
	}
	  
	con.close();  
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return result;
}

public void insertRecord(String item, double cost) {

	  //database JDBC ..	
	try {
		con= CurrencyDao.getConnection();
		String query = " insert into itemcost (productName, cost)"
		        + " values (?, ?)";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString (1, item);
		stmt.setDouble (2, cost);
		stmt.executeUpdate();
		
		
		con.close();  
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}

public double convertCurrencyEuro(double usd) {
	
	double rate=1;
	try {
		con= CurrencyDao.getConnection();
		String query = "select currencyEUR from exchangerate where currencyUSD = 1";
		PreparedStatement stmt=con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery();  
		
		if(rs.next()) rate=rs.getDouble(1);
		System.out.println("rate is:-----"+rate);
		
		con.close();  
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	return rate;
}

public  double convertCurrencyInr(double usd) {
	
	double rate=1;
	try {
		con= CurrencyDao.getConnection();
		String query = "select currencyINR from exchangerate where currencyUSD= 1";
		PreparedStatement stmt=con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()) rate=rs.getDouble(1);
		System.out.println("rate is:-----"+rate);
		
		con.close();  
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	return rate;
}
}
