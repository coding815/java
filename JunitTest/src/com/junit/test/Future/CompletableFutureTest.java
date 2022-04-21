package com.junit.test.Future;

import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {

	@Test
	public void completableFutureTest() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = new CompletableFuture<>();
		
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(2000);
			future.complete("Finished");
			return null;
		});
		
		log(future.get());
	}
	
	@Test
	public void completableFutureTest2() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = CompletableFuture.completedFuture("Skip!");
		
		String result = completableFuture.get();
		log(result);
	}
	
	@Test
	public void completableFutureTest3() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "future example");
		
		log("get():" + future.get());
	}
	
	@Test
	public void completableFutureTest4() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			log("Starting.....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return "Finished works";
		});
		
		log("get():" + future.get());
	}
	
	@Test
	public void completableFutureTest5() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> log("future example"));

		
		log("get():" + future.get());
	}
	
	@Test
	public void completableFutureTest6() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			String name = null;
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		}).handle((s, t) -> s != null ? s : "Hello, Stranger!");
		
		log(future.get());
	}
	
	public void log(String msg) {
		System.out.println(LocalTime.now() + " ("
				+ Thread.currentThread().getName() + ") " + msg);
	}
}

