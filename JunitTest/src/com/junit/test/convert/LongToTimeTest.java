package com.junit.test.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class LongToTimeTest {
	
	@Test
	public void LongToTimeTest() throws Exception {
//        long time =  System.currentTimeMillis();
		long timeLong = 1648704600000L;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(timeLong);
        System.out.println("timeLong: " + strDate);    

	}
	
	@Test
	public void StringToDateTest() throws Exception {
		String timeStr = "2022-03-07 15:21:00";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timeDate = sdf.parse(timeStr);
        System.out.println("timeDate: " + timeDate);    

	}
	
	@Test
	public void StringToLongTest() throws Exception {
		String timeStr = "2022-03-07 15:21:00";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formatDate = sdf.parse(timeStr);
        long timeLong = formatDate.getTime();
        System.out.println("timeLong: " + timeLong);    

	}
	
}

