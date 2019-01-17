package com.Async.Async.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Async.Async.model.Costumer;
import com.Async.Async.service.AsyncService;

@RestController
public class AsyncController {

	
	@Autowired
	public AsyncService asyncService;
	
	@PostMapping("/save")
	public Costumer populate(@RequestBody Costumer costumer) {
		Costumer c=asyncService.uploadCostumer(costumer);
		return c;
	}
	
	@GetMapping("/getAll")
	public List<Costumer> getAllCostumers() {
		Future<List<Costumer>> futures= asyncService.getAllCostumers();
		List<Costumer> costumers= new ArrayList<>();
		
		try {
			costumers= futures.get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return costumers;
		
	}
	
//	@GetMapping("/getAsynchronously")
//	public Costumer getAsynchronously() throws InterruptedException, ExecutionException {
//		Future<Costumer> future= asyncService.getCostumerAsynchronously();
//		
//		while(true) {
//			if(future.isDone()) {
//				System.out.println(future.get().toString());
//			}
//			System.out.println("Continue to do something el;se");
//			Thread.sleep(1000);
//		}
//	}
	
		
}
