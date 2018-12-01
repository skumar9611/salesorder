package com.orderapi.salesproject;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesRepository extends MongoRepository<SalesProduct,String> {

	Optional<SalesProduct> findById(String id);

	
}
