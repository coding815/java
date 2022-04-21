package com.junit.test.timer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {

	public static void main(String[] args) {
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(new Date() + " : Executing the task from "
				+ Thread.currentThread().getName());
			}
		};
		
		LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(3);
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		Timer timer = new Timer("Timer");
		System.out.println(new Date() + " : Scheduling.....");
		timer.schedule(task, date);
	}

}