package com.junit.test.convert;

import org.junit.Test;

public class CharAtTest {

	@Test
	public void charAtTest() throws Exception {
		String testStr = "gofabric-service-5vkwg";
		String subStr = testStr.substring(0, 2);
		System.out.println("subStr: " + subStr);
	}
	
	
}
