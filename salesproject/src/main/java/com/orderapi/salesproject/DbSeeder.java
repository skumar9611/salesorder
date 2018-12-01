package com.orderapi.salesproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class DbSeeder implements CommandLineRunner {
	
	private SalesRepository saleRepository;
	
	
	public DbSeeder(SalesRepository saleRepository) {
		this.saleRepository = saleRepository;
	}


	@Override
	public void run(String...strings) throws Exception{
		SalesProduct aman=new SalesProduct("1",
				Arrays.asList(new Product("Louis Phillipe", "Shirt", "M", 1224, true, 2),
						new Product("Arrows", "T-Shirt", "M", 2224, true, 1)));
		SalesProduct sharath=new SalesProduct("2",
				Arrays.asList(new Product("Louis Phillipe", "T-Shirt", "M", 1224, false, 2),
						new Product("Arrows", "T-Shirt", "M", 2224, true, 4)));
	
		//drop sales
		this.saleRepository.deleteAll();
	List<SalesProduct> customers = Arrays.asList(aman,sharath);
	this.saleRepository.saveAll(customers);
	}
	
	
}
