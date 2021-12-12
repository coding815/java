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
		
			System.out.print("ù��° ���� �Է��ϼ���.: ");
			
			firstInputString = scanner.next();
		
			if(isNumeric(firstInputString)) {
				System.out.println("ù��° �Է°�: " + firstInputString);
			} else {
				System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
			}
			
//			System.out.println("isNumeric: " + isNumeric(firstInputString));
		}
		
		while(!isArithmeticSign(arithmeticSignString)) {
		
			System.out.println("����� ��ȣ�� �����ϼ���. (���ڷ� �Է� �� ����)");
			System.out.print("1. +(���ϱ�) | 2. -(����) | 3. *(���ϱ�) | 4. /(������) | 5. %(������): ");
			
			arithmeticSignString = scanner.next();
			
			if(isArithmeticSign(arithmeticSignString)) {
				arithmeticSignInt = Integer.parseInt(arithmeticSignString);
			} else {
				System.out.println("�Է��Ͻ� ���� ��ȿ���� ���� �����Դϴ�.");
			}
			
			String checkAarithmeticSign = "";
			
			switch(arithmeticSignInt) {
				case ARITHMETIC_SIGN_ADDITION:
					checkAarithmeticSign = "1. +(���ϱ�)";
					break;
				case ARITHMETIC_SIGN_SUBTRACTION:
					checkAarithmeticSign = "2. -(����)";
					break;
				case ARITHMETIC_SIGN_MULTIPLICATION:
					checkAarithmeticSign = "3. *(���ϱ�)";
					break;
				case ARITHMETIC_SIGN_DIVISION:
					checkAarithmeticSign = "4. /(������)";
					break;
				case ARITHMETIC_SIGN_REMAINDER:
					checkAarithmeticSign = "5. %(������)";
					break;
			}
			
			System.out.println("�Էµ� ��ȣ: " + checkAarithmeticSign);
		}
		
		while(!isNumeric(secondInputString)) {
			
			System.out.print("�ι�° ���� �Է��ϼ���.: ");
			
			secondInputString = scanner.next();
		
			if(isNumeric(secondInputString)) {
				System.out.println("�ι�° �Է°�: " + secondInputString);
			} else {
				System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
			}
			
		}
		
		BigDecimal firstBigDecimal = new BigDecimal(firstInputString);
		BigDecimal secondBigDecimal = new BigDecimal(secondInputString);
		
		System.out.print("��� ���: ");
		
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
