package phone;

import button.Button;

public class PhoneButton extends Button {
	
	@Override
	public String pressButton() {
		
		String pressButtonString = "";
		
		while (!isCheckNumber(pressButtonString)) {
			
			pressButtonString = super.pressButton();
			
			if(!isCheckNumber(pressButtonString)) {
				System.out.println("전화기에서 지원하지 않는 버튼입니다.");
			}
		}
		
		System.out.println("입력된 버튼: " + pressButtonString);
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
