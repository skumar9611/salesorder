package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.SalesOrder;
import com.javasampleapproach.springrest.mysql.repo.SalesOrderRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalesOrderController {

	@Autowired
	SalesOrderRepository repository;

	@GetMapping("/salesorder")
	public List<SalesOrder> getAllSalesOrders() {
		System.out.println("Get all salesorder...");

		List<SalesOrder> salesorders = new ArrayList<>();
		repository.findAll().forEach(salesorders::add);

		return salesorders;
	}

	@PostMapping(value = "/salesorder/create")
	public SalesOrder postSalesOrder(@RequestBody SalesOrder salesorder) {

		SalesOrder _salesorder = repository.save(new SalesOrder(salesorder.getName()));
		return _salesorder;
	}

	@DeleteMapping("/salesorder/{id}")
	public ResponseEntity<String> deleteSalesOrder(@PathVariable("id") long id) {
		System.out.println("Delete SalesOrder with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("SalesOrder has been deleted!", HttpStatus.OK);
	}

	@PutMapping("/salesorder/{id}")
	public ResponseEntity<SalesOrder> updateSalesOrder(@PathVariable("id") long id, @RequestBody SalesOrder salesorder) {
		System.out.println("Update SalesOrder with ID = " + id + "...");

		Optional<SalesOrder> salesorderData = repository.findById(id);

		if (salesorderData.isPresent()) {
			SalesOrder _salesorder = salesorderData.get();
			_salesorder.setName(salesorder.getName());
			return new ResponseEntity<>(repository.save(_salesorder), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
