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
	private int listIdGen;

	public SalesProduct() {
		this.products = new ArrayList<>();
	}

	public SalesProduct(String name,List<Product> products) {
		this.name = name;
		this.products = products;
		listIdGen=0;
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

	public int getListIdGen() {
		return listIdGen;
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
	
	public int setListIdGen() {
		this.listIdGen = this.listIdGen+1;
		return this.listIdGen;
	}
	
	public void addProduct(Product product)	{
		this.products.add(product);
	}
	
	public void deleteProduct(String pid)	{
		int index=-1;
		for(int i = 0 ; i < products.size() ; i++)
		{
			if(products.get(i).getId().equals(pid))
			{
				index=i;
				break;
			}
		}
		this.products.remove(index);		
	}

}
