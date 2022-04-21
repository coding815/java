package com.junit.test.convert;

import org.junit.Test;

public class LengthOfStringTest {
	
	@Test
	public void getByteByStringTest() {
		String test = "255.255.255.255";
		int length = test.getBytes().length;
		System.out.println("ByteOfString: " + length); 
	}
	
	
	@Test
	public void getLengthByStringTest() {
		String test = "";
		int length = test.length();
		System.out.println("ByteOfString: " + length); 
	}
}
