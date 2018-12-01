package com.orderapi.salesproject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SalesProduct")
public class SalesProduct {
	@Id
	private String id;
	private List<Product> products;

	public SalesProduct() {
		this.products = new ArrayList<>();
	}

	public SalesProduct(String id, List<Product> products) {
		this.id = id;
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products;
	}

}
