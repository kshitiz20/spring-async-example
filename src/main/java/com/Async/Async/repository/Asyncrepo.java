package com.Async.Async.repository;

import java.util.List;

import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.Async.Async.model.Costumer;

@Repository
public interface Asyncrepo extends CrudRepository<Costumer, Integer>{
	
	@Async
	@Query("select c from Costumer c")
	Future<List<Costumer>> findAllCostumers();

}
