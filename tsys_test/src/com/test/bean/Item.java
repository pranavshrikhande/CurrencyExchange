package com.test.bean;

public class Item {

	private int id;

	public int getId() {
		return id;
	}

	private String item;

	private double cost;
	
	
	
	public Item() {

	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", item=" + item + ", cost=" + cost + "]";
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
