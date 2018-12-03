package com.orderapi.salesproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MyRestController {
	@Autowired
	private SalesRepository salesRepository;

	public MyRestController(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/salesorder")
	public List<SalesProduct> getAll() {
		List<SalesProduct> salesproducts = this.salesRepository.findAll();
		return salesproducts;
	}
	
	@GetMapping("/salesorder/products/{id}")
	public List<Product> getProdById(@PathVariable("id") String id) {
		Optional<SalesProduct> salesproducts = this.salesRepository.findById(id);
		List<Product> products = salesproducts.get().getProducts();
		return products;
	}

	@PutMapping("/salesorder/{id}/{name}")
	public void insert(@PathVariable("id") String id,@PathVariable("name") String name) {
		Optional<SalesProduct> prods = this.salesRepository.findById(id);
		prods.get().setId(id);
		prods.get().setName(name);
		this.salesRepository.save(prods.get());

	}
	
	@PostMapping(value = "/salesorder/create")
	public void update(@RequestBody SalesProduct salesproduct) {
		this.salesRepository.save(salesproduct);
	}
	
	@DeleteMapping("/salesorder/{id}")
	public void delete(@PathVariable("id") String id) {
		this.salesRepository.deleteById(id);
	}

	@GetMapping("/salesorder/{id}")
	public Optional<SalesProduct> getById(@PathVariable("id") String id) {
		Optional<SalesProduct> saleproduct = this.salesRepository.findById(id);
		return saleproduct;
	}

}
