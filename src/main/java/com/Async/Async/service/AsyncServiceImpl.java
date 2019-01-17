package com.Async.Async.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.Async.Async.model.Costumer;
import com.Async.Async.repository.Asyncrepo;

@Service
public class AsyncServiceImpl implements AsyncService{
	
	List<Costumer> customerDB= new ArrayList<Costumer>();
	
	@Autowired
	public Asyncrepo repo;
	
	

	@Override
		public Future<List<Costumer>> getAllCostumers() {
		// TODO Auto-generated method stub
		
	//System.out.println("###################"+repo.findAll());
	
	return repo.findAllCostumers();
		
	}




	@Override
	public Costumer uploadCostumer(Costumer costumer) {
		
		
		Costumer c=repo.save(costumer);
		
		return c;
		// TODO Auto-generated method stub
		
	}
	
	
	List<Costumer> FakeCustomerList= new ArrayList<>();
	
	@Override
	public Future<Costumer> getCostumerAsynchronously() throws InterruptedException, ExecutionException{
		FakeCustomerList= repo.findAllCostumers().get();
		System.out.println("Execute method asynchronously - "
			      + Thread.currentThread().getName());
		
		for(int i=0;i<FakeCustomerList.size();i++) {
			
			try {
				if(FakeCustomerList.get(i).getName().equals("Kshitiz"))
				{ Thread.sleep(5000);
		        
		        return new AsyncResult<Costumer>(FakeCustomerList.get(i));}
		    } catch (InterruptedException e) {
		        //
		    }
			
		}
		return null;
		
		
		
		
	}

}
