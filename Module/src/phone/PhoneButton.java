package phone;

import java.util.Scanner;

import button.Button;
import button.ButtonModel;

public class PhoneButton extends Button {
	
	public String pressButton() {
		
		ButtonModel buttonModel = new ButtonModel();
		
		String pressButtonString = buttonModel.getPressButton();
		
		pressButtonString = "";
		
		while (!isCheckNumber(pressButtonString)) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("��ư�� �����ϴ�.: ");
			
			pressButtonString = scanner.next();
//			System.out.println("inputButtonString: " + buttonModel.pressButton);
			
			if(!isCheckNumber(pressButtonString)) {
				System.out.println("��ȭ�⿡�� �������� �ʴ� ��ư�Դϴ�.");
			}
		}
		
		System.out.println("�Էµ� ��ư: " + pressButtonString);
		return pressButtonString;
	}
	
	public boolean isCheckNumber(String string) {
		String regExp = "^[0-9]+$";
		
		if (string.matches(regExp)) {
//			System.out.println("true");
			return true;
		}
//		System.out.println("false");
		return false;
	}

}
