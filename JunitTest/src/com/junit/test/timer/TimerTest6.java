package com.junit.test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest6 {

	public static void main(String[] args) throws InterruptedException {
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(new Date() + " : Executing the task from "
				+ Thread.currentThread().getName());
			}
		};
		
		Timer timer = new Timer("Timer");
		System.out.println(new Date() + " : Scheduling.....");
		timer.schedule(task, 1000, 1000);
		
		Thread.sleep(5000);
		System.out.println(new Date() + " : Canceling Timer.....");
		timer.cancel();

	}

}
