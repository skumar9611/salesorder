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

	@PutMapping("/salesorder/{id,name}")
	public void insert(@PathVariable("id") String id,@PathVariable("name") String name) {
		//this.salesRepository.save(salesproduct);
	//	Query query = new Query();
	//	query.addCriteria(Criteria.where("id").is(id));

		//SalesProduct prod = this.salesRepository.findOne(query, SalesProduct.class);

		//modify and update with save()
		//prod.setName(name);
	//	this.salesRepository.save(prod);
		SalesProduct prod = new SalesProduct();
		prod.setId(id);
		prod.setName(name);
		this.salesRepository.save(prod);

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
