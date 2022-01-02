package phone.sender;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import phone.button.PhoneButtonEnum;
import phone.status.PhoneStatusEnum;

public class Sender {
	
	PhoneStatusEnum phoneStatusEnum = PhoneStatusEnum.NORMAL;
	PhoneButtonEnum phoneButtonEnum = PhoneButtonEnum.INIT;
	
	public PhoneStatusEnum pickUpPhone() {
		if (phoneStatusEnum == PhoneStatusEnum.NORMAL) {
			phoneStatusEnum = PhoneStatusEnum.PICKUP;
			System.out.println("du du du . . .");
			return phoneStatusEnum;
		}
		
		return phoneStatusEnum;
	}
	
	public PhoneStatusEnum inputPhoneNumbers() {
		Scanner scanner = new Scanner(System.in);
		
		String inputNumberString = "";
		
		while(phoneStatusEnum == PhoneStatusEnum.PICKUP) {
		
			System.out.print("��ȭ��ȣ�� �Է��ϼ���.: ");
			
			inputNumberString = scanner.next();
			
			if(isCheckHangUp(inputNumberString)) {
				System.out.println("��ȭ�� �����ϴ�.: " + inputNumberString);
				phoneStatusEnum = PhoneStatusEnum.HANGUP;
				return phoneStatusEnum;
			} else {
				if(isCheckNumber(inputNumberString)) {
					System.out.println("�Է��� ��ȭ��ȣ: " + inputNumberString);
					phoneStatusEnum = PhoneStatusEnum.CALLING;
					return phoneStatusEnum;
				} else {
					System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ��ȿ���� ���� ��ȣ�Դϴ�.");
				}
			}
		}
	
		return phoneStatusEnum;
	}
	
	public boolean call() {
		
		try {
			for (int i = 0; i < 3; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("dda r r rng ! ! !");
				
				int responseCalling = responseCalling();
				
				if (responseCalling == 10) {
					System.out.println("hello?!");
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public int responseCalling() {
		int responseRandomSetting = 0;
				
		while(responseRandomSetting == 0) {
			double randomValue = Math.random();
			int intValue = (int)(randomValue * 10) + 1;
//			System.out.println("intValue: " + intValue);
			responseRandomSetting = intValue;
		}
		System.out.println("responseRandomSetting: " + responseRandomSetting);
		
		return responseRandomSetting;
	}
	
	public boolean isCheckHangUp(String string) {
		String regExpQuit = "[qQ]";
		
		if (string.matches(regExpQuit)) {
			return true;
		}
			
		return false;
	}
	
	public boolean isCheckNumber(String string) {
		String regExp = "(02|031|032|033|041|042|043|044|051||052|053|054|055|061|062|063|064|010|070)\\d{3,4}\\d{4}";
		
		if (string.matches(regExp)) {
			
			return true;
		}
			
		return false;
	}
}
