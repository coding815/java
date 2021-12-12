package calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
	private static final int ARITHMETIC_SIGN_ADDITION = 1;
	private static final int ARITHMETIC_SIGN_SUBTRACTION = 2;
	private static final int ARITHMETIC_SIGN_MULTIPLICATION = 3;
	private static final int ARITHMETIC_SIGN_DIVISION = 4;
	private static final int ARITHMETIC_SIGN_REMAINDER = 5;
	
	public static void main(String[] args) {
		
		String firstInputString = "";
		String secondInputString = "";
		String arithmeticSignString = "";
		int arithmeticSignInt = 0;
				
		Scanner scanner = new Scanner(System.in);
		
		while(!isNumeric(firstInputString)) {
		
			System.out.print("첫번째 수를 입력하세요.: ");
			
			firstInputString = scanner.next();
		
			if(isNumeric(firstInputString)) {
				System.out.println("첫번째 입력값: " + firstInputString);
			} else {
				System.out.println("입력하신 값은 숫자가 아닙니다.");
			}
			
//			System.out.println("isNumeric: " + isNumeric(firstInputString));
		}
		
		while(!isArithmeticSign(arithmeticSignString)) {
		
			System.out.println("계산할 부호를 선택하세요. (숫자로 입력 후 엔터)");
			System.out.print("1. +(더하기) | 2. -(빼기) | 3. *(곱하기) | 4. /(나누기) | 5. %(나머지): ");
			
			arithmeticSignString = scanner.next();
			
			if(isArithmeticSign(arithmeticSignString)) {
				arithmeticSignInt = Integer.parseInt(arithmeticSignString);
			} else {
				System.out.println("입력하신 값은 유효하지 않은 범위입니다.");
			}
			
			String checkAarithmeticSign = "";
			
			switch(arithmeticSignInt) {
				case ARITHMETIC_SIGN_ADDITION:
					checkAarithmeticSign = "1. +(더하기)";
					break;
				case ARITHMETIC_SIGN_SUBTRACTION:
					checkAarithmeticSign = "2. -(빼기)";
					break;
				case ARITHMETIC_SIGN_MULTIPLICATION:
					checkAarithmeticSign = "3. *(곱하기)";
					break;
				case ARITHMETIC_SIGN_DIVISION:
					checkAarithmeticSign = "4. /(나누기)";
					break;
				case ARITHMETIC_SIGN_REMAINDER:
					checkAarithmeticSign = "5. %(나머지)";
					break;
			}
			
			System.out.println("입력된 부호: " + checkAarithmeticSign);
		}
		
		while(!isNumeric(secondInputString)) {
			
			System.out.print("두번째 수를 입력하세요.: ");
			
			secondInputString = scanner.next();
		
			if(isNumeric(secondInputString)) {
				System.out.println("두번째 입력값: " + secondInputString);
			} else {
				System.out.println("입력하신 값은 숫자가 아닙니다.");
			}
			
		}
		
		BigDecimal firstBigDecimal = new BigDecimal(firstInputString);
		BigDecimal secondBigDecimal = new BigDecimal(secondInputString);
		
		System.out.print("계산 결과: ");
		
		switch(arithmeticSignInt) {
			case ARITHMETIC_SIGN_ADDITION:
				System.out.println(firstInputString + " + " + secondInputString + " = " + firstBigDecimal.add(secondBigDecimal));
				break;
			case ARITHMETIC_SIGN_SUBTRACTION:
				System.out.println(firstInputString + " - " + secondInputString + " = " + firstBigDecimal.subtract(secondBigDecimal));
				break;
			case ARITHMETIC_SIGN_MULTIPLICATION:
				System.out.println(firstInputString + " * " + secondInputString + " = " + firstBigDecimal.multiply(secondBigDecimal));
				break;
			case ARITHMETIC_SIGN_DIVISION:
				System.out.println(firstInputString + " / " + secondInputString + " = " + firstBigDecimal.divide(secondBigDecimal));
				break;
			case ARITHMETIC_SIGN_REMAINDER:
				System.out.println(firstInputString + " % " + secondInputString + " = " + firstBigDecimal.remainder(secondBigDecimal));
				break;
		}

	}
	
	public static boolean isNumeric(String string) {
		try {
	     	Double.parseDouble(string);
	    	return true;
	    } catch(NumberFormatException e) {
	    	return false;
	    }
	}
	
	public static boolean isArithmeticSign(String string) {
		String checkArithmeticSign = "[1-5]";
		
//		Matcher matcher;
//		
//		matcher = Pattern.compile(checkArithmeticSign).matcher(string);
//		
//		System.out.println("matcher: " + matcher.find());
//		
//		return matcher.find();
		
		if (string.matches(checkArithmeticSign)) {
			return true;
		}
			
		return false;
	}
}
