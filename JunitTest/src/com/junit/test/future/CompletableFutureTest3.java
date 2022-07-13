package com.junit.test.future;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class CompletableFutureTest3 {

	@Test
	public void completableFutureTest() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Future1");
		
		CompletableFuture<String> future2 = future1.thenApply(
				s -> s + " + Future2");
		
		log("future1.get(): " + future1.get());
		log("future2.get(): " + future2.get());
	}
	
	@Test
	public void completableFutureTest2() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture
				.supplyAsync(() -> "Future1")
				.thenApply(s -> s + " + Future2");
		
		log("future.get(): " + future.get());
	}
	
	@Test
	public void completableFutureTest3() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture
				.supplyAsync(() -> "Future")
				.thenApply(s -> s + " Hello")
				.thenApply(s -> s + " World");
		
		log("future.get(): " + future.get());
	}
	
	@Test
	public void completableFutureTest4() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		
		CompletableFuture<Void> future2 = future1.thenAccept(
				s -> log(s + " World"));
		
		log("future1.get(): " + future1.get());
		log("future2.get(): " + future2.get());
	}
	
	public void log(String msg) {
		System.out.println(LocalTime.now() + " ("
				+ Thread.currentThread().getName() + ") " + msg);
	}
}
