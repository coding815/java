package com.junit.test.convert;

import org.junit.Test;

public class StringBufferTest {
	
	@Test
	public void poolListParser() throws Exception {
		StringBuffer sb = new StringBuffer();
		
		System.out.println("sb.length() [0]: " + sb.length());
		System.out.println("sb.toString() [0]: " + sb.toString());
		
		sb.append("NexentaStor-1");
		
		System.out.println("sb.length() [1]: " + sb.length());
		System.out.println("sb.toString() [1]: " + sb.toString());
		
		sb.append(", ");
		
		System.out.println("sb.length() [2]: " + sb.length());
		System.out.println("sb.toString() [2]: " + sb.toString());
		
		sb.append("NexentaStor-2");
		
		System.out.println("sb.length() [3]: " + sb.length());
		System.out.println("sb.toString() [3]: " + sb.toString());
		
		String ubNormalStatusNode = sb.toString();
		
		System.out.println("ubNormalStatusNode.length(): " + ubNormalStatusNode.length());
		System.out.println("ubNormalStatusNode: " + ubNormalStatusNode);
	
	}

}
