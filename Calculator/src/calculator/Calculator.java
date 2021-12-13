package calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
	// enum으로 처리 - 행위를  명확하게 알 수 있다.
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
			System.out.print("첫번째 수를 입력하세요.: ");
			
			firstOperandString = scanner.next();
		
			if(isNumeric(firstOperandString)) {
				System.out.println("첫번째 입력값: " + firstOperandString);
				break;
			} else {
				System.out.println("입력하신 값은 숫자가 아닙니다.");
			}
			
//			System.out.println("isNumeric: " + isNumeric(firstOperandString));
		}
		
		while(!isArithmeticOperator(arithmeticOperatorString)) {
		
			System.out.println("계산할 부호를 선택하세요. (숫자로 입력 후 엔터)");
			System.out.print("1. +(더하기) | 2. -(빼기) | 3. *(곱하기) | 4. /(나누기) | 5. %(나머지): ");
			
			arithmeticOperatorString = scanner.next();
			
			if(isArithmeticOperator(arithmeticOperatorString)) {
				arithmeticOperatorInt = Integer.parseInt(arithmeticOperatorString);
			} else {
				System.out.println("입력하신 값은 유효하지 않은 범위입니다.");
			}
			
			String checkAarithmeticOperator = "";
			
			switch(arithmeticOperatorInt) {
				case ARITHMETIC_OPERATOR_ADDITION:
					checkAarithmeticOperator = "1. +(더하기)";
					break;
				case ARITHMETIC_OPERATOR_SUBTRACTION:
					checkAarithmeticOperator = "2. -(빼기)";
					break;
				case ARITHMETIC_OPERATOR_MULTIPLICATION:
					checkAarithmeticOperator = "3. *(곱하기)";
					break;
				case ARITHMETIC_OPERATOR_DIVISION:
					checkAarithmeticOperator = "4. /(나누기)";
					break;
				case ARITHMETIC_OPERATOR_REMAINDER:
					checkAarithmeticOperator = "5. %(나머지)";
					break;
			}
			
			System.out.println("입력된 부호: " + checkAarithmeticOperator);
		}
		
		while(!isNumeric(secondOperandString)) {
			
			System.out.print("두번째 수를 입력하세요.: ");
			
			secondOperandString = scanner.next();
		
			if(isNumeric(secondOperandString)) {
				System.out.println("두번째 입력값: " + secondOperandString);
			} else {
				System.out.println("입력하신 값은 숫자가 아닙니다.");
			}
			
		}
		
		BigDecimal firstBigDecimal = new BigDecimal(firstOperandString);
		BigDecimal secondBigDecimal = new BigDecimal(secondOperandString);
		
		System.out.print("계산 결과: ");
		
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
