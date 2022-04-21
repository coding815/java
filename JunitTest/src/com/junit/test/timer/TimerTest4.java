package com.junit.test.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest4 {

	public static void main(String[] args) {
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(LocalDateTime.now() + " : Executing the task from "
				+ Thread.currentThread().getName());
			}
		};
		
		Timer timer = new Timer("Timer");
		long delay = 3000L;
		long period =  1000L;
		System.out.println(LocalDateTime.now() + " : Scheduling.....");
		timer.scheduleAtFixedRate(task, delay, period);

	}

}
