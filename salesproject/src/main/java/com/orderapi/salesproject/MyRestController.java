package com.orderapi.salesproject;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class MyRestController {
	private SalesRepository salesRepository;

	public MyRestController(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/all")
	public List<SalesProduct> getAll() {
		List<SalesProduct> salesproducts = this.salesRepository.findAll();
		return salesproducts;
	}

	@PutMapping
	public void insert(@RequestBody SalesProduct salesproduct) {
		this.salesRepository.insert(salesproduct);
	}

	@PostMapping
	public void update(@RequestBody SalesProduct salesproduct) {
		this.salesRepository.save(salesproduct);
	}

	@DeleteMapping
	public void delete(@PathVariable("id") String id) {
		this.salesRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public Optional<SalesProduct> getById(@PathVariable("id") String id) {
		Optional<SalesProduct> saleproduct = this.salesRepository.findById(id);
		return saleproduct;
	}

}
