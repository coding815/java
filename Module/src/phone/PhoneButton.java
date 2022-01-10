package phone;

import button.Button;

public class PhoneButton extends Button {
	
	@Override
	public String pressButton() {
		
		String pressButtonString = "";
		
		while (!isCheckNumber(pressButtonString)) {
			
			pressButtonString = super.pressButton();
			
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
