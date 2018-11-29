package com.example.saleproject;

public class salesProduct {
	private int id;
	private String name;
	private int price;

	public salesProduct() {

	}

	public salesProduct(int id, String name, int price) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
	}

	/**
	 * @return the id,name,price
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param name the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	/**
	 * @param name the price to set
	 */

	public void setPrice(int price) {
		this.price = price;
	}

}