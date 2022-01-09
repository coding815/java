package phone;

import java.util.Scanner;

import button.Button;
import button.ButtonModel;

public class PhoneButton extends Button {
	
	public String pressButton() {
		
		ButtonModel buttonModel = new ButtonModel();
		
		buttonModel.pressButton = "";
		
		while (!isCheckNumber(buttonModel.pressButton)) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("버튼을 누릅니다.: ");
			
			buttonModel.pressButton = scanner.next();
//			System.out.println("inputButtonString: " + buttonModel.pressButton);
			
			if(!isCheckNumber(buttonModel.pressButton)) {
				System.out.println("전화기에서 지원하지 않는 버튼입니다.");
			}
		}
		
		System.out.println("입력된 버튼: " + buttonModel.pressButton);
		return buttonModel.pressButton;
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
