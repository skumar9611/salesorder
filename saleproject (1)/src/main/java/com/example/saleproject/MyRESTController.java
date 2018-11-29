package com.example.saleproject;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	/**
	 * This returns Hello World string
	 * 
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	/**
	 * When you query with helloParams?, it returns id,product name,price
	 * 
	 * @param id,name,price
	 * @return
	 */
	@RequestMapping("/helloParamsId")
	public int helloWithParamsId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return id;
	}

	@RequestMapping("/helloParamsName")
	public String helloWithParamsName(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Product " + name;
	}

	@RequestMapping("/helloParamsPrice")
	public int helloWithParamsPrice(@RequestParam(value = "price", defaultValue = "Rupees") int price) {
		return price;
	}
	@RequestMapping("/products")
	  public List<salesProduct> getsalesList() {
	    salesProduct c1 = new salesProduct(13232,"t-shirt",2434);
	    salesProduct c2 = new salesProduct(13242,"shoe",5344);
	    List<salesProduct> salesList = new ArrayList<>();
	    salesList.add(c1);
	    salesList.add(c2);
	    return salesList;
	  }
}