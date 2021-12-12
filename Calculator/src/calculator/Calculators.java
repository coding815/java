package calculator;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculators {
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
		String yesOrNoString = "";
				
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("########## Calculator On ##########");
		

		

		
		while(!isArithmeticOperator(arithmeticOperatorString)) {
		
			System.out.println("����� ��ȣ�� �����ϼ���. (���ڷ� �Է� �� ����)");
			System.out.print("1. +(���ϱ�) | 2. -(����) | 3. *(���ϱ�) | 4. /(������) | 5. %(������): ");
			
			arithmeticOperatorString = scanner.next();
			
			if(isArithmeticOperator(arithmeticOperatorString)) {
				arithmeticOperatorInt = Integer.parseInt(arithmeticOperatorString);
			} else {
				System.out.println("�Է��Ͻ� ���� ��ȿ���� ���� �����Դϴ�.");
			}
			
			String checkAarithmeticOPERATOR = "";
			
			switch(arithmeticOperatorInt) {
				case ARITHMETIC_OPERATOR_ADDITION:
					checkAarithmeticOPERATOR = "1. +(���ϱ�)";
					break;
				case ARITHMETIC_OPERATOR_SUBTRACTION:
					checkAarithmeticOPERATOR = "2. -(����)";
					break;
				case ARITHMETIC_OPERATOR_MULTIPLICATION:
					checkAarithmeticOPERATOR = "3. *(���ϱ�)";
					break;
				case ARITHMETIC_OPERATOR_DIVISION:
					checkAarithmeticOPERATOR = "4. /(������)";
					break;
				case ARITHMETIC_OPERATOR_REMAINDER:
					checkAarithmeticOPERATOR = "5. %(������)";
					break;
			}
			
			System.out.println("�Էµ� ��ȣ: " + checkAarithmeticOPERATOR);
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
		
		while(!isYesOrNo(yesOrNoString)) {
			
			System.out.print("����� ����Ͻðڽ��ϱ�?: ");
			
			yesOrNoString = scanner.next();
		
			if(isYesOrNo(yesOrNoString)) {
				System.out.println("isYesOrNo: " + yesOrNoString);
				if(yesOrNoString.equals("Y") || yesOrNoString.equals("y")) {
					firstOperandString = secondOperandString;
				}
			} else {
				System.out.println("Y(y) �Ǵ� N(n)�� �Է��ϼ���.");
			}
			
			if(yesOrNoString.equals("N") || yesOrNoString.equals("n")) {
				System.out.println("����� �����մϴ�.");
				break;
			}
			
		}
		
		System.out.print("########## Calculator Off ##########");

	}
	
	public String firstOperlandInput() {
		String firstOperandString = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while(!isNumeric(firstOperandString)) {
			
			System.out.print("ù��° ���� �Է��ϼ���.: ");
			
			firstOperandString = scanner.next();
		
			if(isNumeric(firstOperandString)) {
				System.out.println("ù��° �Է°�: " + firstOperandString);
			} else {
				System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
			}
			
//			System.out.println("isNumeric: " + isNumeric(firstOperandString));
		}
		
		return firstOperandString;
	}
	
	public static boolean isNumeric(String string) {
		try {
	     	Double.parseDouble(string);
	    	return true;
	    } catch(NumberFormatException e) {
	    	return false;
	    }
	}
	
	public static boolean isArithmeticOperator(String string) {
		String checkArithmeticOperator = "[1-5]";
		
//		Matcher matcher;
//		
//		matcher = Pattern.compile(checkArithmeticOPERATOR).matcher(string);
//		
//		System.out.println("matcher: " + matcher.find());
//		
//		return matcher.find();
		
		if (string.matches(checkArithmeticOperator)) {
			return true;
		}
			
		return false;
	}
	
	public static boolean isYesOrNo(String string) {
		String regExpYesOrNo = "[x-yX-Y]";
		
		if (string.matches(regExpYesOrNo)) {
			return true;
		}
			
		return false;
	}
}
