package com.junit.test.convert;

import java.util.Random;

import org.junit.Test;

public class LottoTest {
	@Test
	public void lottoTest( ) {
		System.out.println("lottoTest: " + "lottoTest!!!");
		
		double randomValue = Math.random();
		int intValue = (int)(randomValue * 100) + 1;
		System.out.println("intValue: " + intValue);
	}
	
	@Test
	public void lottoTest2() {
		System.out.println("lottoTest2: " + "lottoTest2!!!");
		
		Random random = new Random();
		
		for (int i=0;i <6; i++) {
			System.out.println("[" + (random.nextInt(45) + 1) + "]");
		}
	}
	
	@Test
	public void lottoTest3() {
		creatRandomLottoNumber();
	}
	
	public int creatRandomLottoNumber() {
		int randomLottoNumber = 0;
		
		double randomValue = Math.random();
		int intValue = (int)(randomValue * 100) + 1;
		System.out.println("intValue: " + intValue);
		
		while(randomLottoNumber == 0) {
			if (intValue > 0 && intValue < 46) {
				randomLottoNumber = intValue;
			}
		}
		
		System.out.println("randomLottoNumber: " + randomLottoNumber);
		
		return randomLottoNumber;
	}
	
}
