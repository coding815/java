package calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
	// enum���� ó�� - ������  ��Ȯ�ϰ� �� �� �ִ�.
	private static final int ARITHMETIC_OPERATOR_ADDITION = 1;
	private static final int ARITHMETIC_OPERATOR_SUBTRACTION = 2;
	private static final int ARITHMETIC_OPERATOR_MULTIPLICATION = 3;
	private static final int ARITHMETIC_OPERATOR_DIVISION = 4;
	private static final int ARITHMETIC_OPERATOR_REMAINDER = 5;
	
	public static void main(String[] args) {
		
		String firstOperandString = "";
		String secondOperandString = "";
		String arithmeticOperatorString = "";
		int arithmeticOperatorInt = 0;
				
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("ù��° ���� �Է��ϼ���.: ");
			
			firstOperandString = scanner.next();
		
			if(isNumeric(firstOperandString)) {
				System.out.println("ù��° �Է°�: " + firstOperandString);
				break;
			} else {
				System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
			}
			
//			System.out.println("isNumeric: " + isNumeric(firstOperandString));
		}
		
		while(!isArithmeticOperator(arithmeticOperatorString)) {
		
			System.out.println("����� ��ȣ�� �����ϼ���. (���ڷ� �Է� �� ����)");
			System.out.print("1. +(���ϱ�) | 2. -(����) | 3. *(���ϱ�) | 4. /(������) | 5. %(������): ");
			
			arithmeticOperatorString = scanner.next();
			
			if(isArithmeticOperator(arithmeticOperatorString)) {
				arithmeticOperatorInt = Integer.parseInt(arithmeticOperatorString);
			} else {
				System.out.println("�Է��Ͻ� ���� ��ȿ���� ���� �����Դϴ�.");
			}
			
			String checkAarithmeticOperator = "";
			
			switch(arithmeticOperatorInt) {
				case ARITHMETIC_OPERATOR_ADDITION:
					checkAarithmeticOperator = "1. +(���ϱ�)";
					break;
				case ARITHMETIC_OPERATOR_SUBTRACTION:
					checkAarithmeticOperator = "2. -(����)";
					break;
				case ARITHMETIC_OPERATOR_MULTIPLICATION:
					checkAarithmeticOperator = "3. *(���ϱ�)";
					break;
				case ARITHMETIC_OPERATOR_DIVISION:
					checkAarithmeticOperator = "4. /(������)";
					break;
				case ARITHMETIC_OPERATOR_REMAINDER:
					checkAarithmeticOperator = "5. %(������)";
					break;
			}
			
			System.out.println("�Էµ� ��ȣ: " + checkAarithmeticOperator);
		}
		
		while(!isNumeric(secondOperandString)) {
			
			System.out.print("�ι�° ���� �Է��ϼ���.: ");
			
			secondOperandString = scanner.next();
		
			if(isNumeric(secondOperandString)) {
				System.out.println("�ι�° �Է°�: " + secondOperandString);
			} else {
				System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
			}
			
		}
		
		BigDecimal firstBigDecimal = new BigDecimal(firstOperandString);
		BigDecimal secondBigDecimal = new BigDecimal(secondOperandString);
		
		System.out.print("��� ���: ");
		
		switch(arithmeticOperatorInt) {
			case ARITHMETIC_OPERATOR_ADDITION:
				System.out.println(firstOperandString + " + " + secondOperandString + " = " + firstBigDecimal.add(secondBigDecimal));
				break;
			case ARITHMETIC_OPERATOR_SUBTRACTION:
				System.out.println(firstOperandString + " - " + secondOperandString + " = " + firstBigDecimal.subtract(secondBigDecimal));
				break;
			case ARITHMETIC_OPERATOR_MULTIPLICATION:
				System.out.println(firstOperandString + " * " + secondOperandString + " = " + firstBigDecimal.multiply(secondBigDecimal));
				break;
			case ARITHMETIC_OPERATOR_DIVISION:
				System.out.println(firstOperandString + " / " + secondOperandString + " = " + firstBigDecimal.divide(secondBigDecimal));
				break;
			case ARITHMETIC_OPERATOR_REMAINDER:
				System.out.println(firstOperandString + " % " + secondOperandString + " = " + firstBigDecimal.remainder(secondBigDecimal));
				break;
		}

	}
	
	private static boolean isNumeric(String string) {
		try {
	     	Double.parseDouble(string);
	    	return true;
	    } catch(NumberFormatException e) {
	    	return false;
	    }
	}
	
	private static boolean isArithmeticOperator(String string) {
		String checkArithmeticOperator = "[1-5]";
		
//		Matcher matcher;
//		
//		matcher = Pattern.compile(checkArithmeticOperator).matcher(string);
//		
//		System.out.println("matcher: " + matcher.find());
//		
//		return matcher.find();
		
		if (string.matches(checkArithmeticOperator)) {
			return true;
		}
			
		return false;
	}
}
