package com.junit.test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest5 {

	public static void main(String[] args) {
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(new Date() + " : Executing the task from "
				+ Thread.currentThread().getName());

				this.cancel();
			}
		};
		
		Timer timer = new Timer("Timer");
		System.out.println(new Date() + " : Scheduling.....");
		timer.schedule(task, 0, 1000);

	}

}
