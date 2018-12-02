package com.orderapi.salesproject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SalesProduct")
public class SalesProduct {
	@Id
	private String id;
	private String name; 
	private List<Product> products;

	public SalesProduct() {
		this.products = new ArrayList<>();
	}

	public SalesProduct(String name,List<Product> products) {
		this.name = name;
		this.products = products;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
