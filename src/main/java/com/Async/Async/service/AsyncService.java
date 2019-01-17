package com.Async.Async.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.Async.Async.model.Costumer;

public interface AsyncService {
	
	public Future<List<Costumer>> getAllCostumers();

	public Costumer uploadCostumer(Costumer costumer);

	Future<Costumer> getCostumerAsynchronously() throws InterruptedException, ExecutionException;
}
