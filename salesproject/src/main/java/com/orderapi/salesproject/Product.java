package com.orderapi.salesproject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SalesProduct")
public class Product {
	
	@Id
	private String id;
	private String productName;
	private String type;
	private String size;
	private int price;
	private boolean approved;
	private int quantity;

	
	public Product() {	}

	public Product(String productName, String type, String size, int price, boolean approved, int quantity) {

		this.productName = productName;
		this.type = type;
		this.size = size;
		this.price = price;
		this.approved = approved;
		this.quantity = quantity;
	}

	public String getId(){
		return id;
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
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}
