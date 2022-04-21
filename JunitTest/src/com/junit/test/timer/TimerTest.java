package com.junit.test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class TimerTest {
	
	@Test
	public void timerTest() throws Exception {
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(new Date() + " : Executing the task from "
				+ Thread.currentThread().getName());
			}
		};
		
		Timer timer = new Timer("Timer");
		long delay = 3000L;
		System.out.println(new Date() + " : Scheduling.....");
		timer.schedule(task, delay);
		
	}

}
