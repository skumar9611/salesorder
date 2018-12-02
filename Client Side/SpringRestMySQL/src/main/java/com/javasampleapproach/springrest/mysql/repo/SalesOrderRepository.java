package com.javasampleapproach.springrest.mysql.repo;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.springrest.mysql.model.SalesOrder;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> { }
