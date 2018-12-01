package com.orderapi.salesproject;

public class Product {

	private String productName;
	private String type;
	private String size;
	private int price;
	private boolean approved;
	private int quantity;

	public Product() {

	}

	public Product(String productName, String type, String size, int price, boolean approved, int quantity) {

		this.productName = productName;
		this.type = type;
		this.size = size;
		this.price = price;
		this.approved = approved;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}

	public boolean isApproved() {
		return approved;
	}

	public int getQuantity() {
		return quantity;
	}


}
