package phone.sender;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import phone.button.PhoneButtonEnum;
import phone.connector.PhoneConnectorEnum;
import phone.response.ResponseCall;
import phone.status.PhoneStatusEnum;

public class Sender {

	PhoneStatusEnum phoneStatusEnum = PhoneStatusEnum.NORMAL;
	
	public PhoneStatusEnum pickUpPhone() {
		if (phoneStatusEnum == PhoneStatusEnum.NORMAL) {
			phoneStatusEnum = PhoneStatusEnum.WAITING;
			System.out.println("### du du du . . . ###");
			return phoneStatusEnum;
		}
		
		return phoneStatusEnum;
	}
	
	public PhoneStatusEnum inputPhoneNumber() {
		Scanner scanner = new Scanner(System.in);
		
		String inputNumberString = "";
		
		while(phoneStatusEnum == PhoneStatusEnum.WAITING) {
		
			System.out.print("전화번호를 입력하세요.: ");
			
			inputNumberString = scanner.next();
			
			if(isCheckHangUp(inputNumberString)) {
				System.out.println("전화를 끊습니다.: " + inputNumberString);
				phoneStatusEnum = PhoneStatusEnum.HANGUP;
				return phoneStatusEnum;
			} else {
				if(isCheckNumber(inputNumberString)) {
					System.out.println("입력한 전화번호: " + inputNumberString);
					phoneStatusEnum = PhoneStatusEnum.CALLING;
					return phoneStatusEnum;
				} else {
					System.out.println("입력하신 전화번호는 유효하지 않은 번호입니다.");
				}
			}
		}
	
		return phoneStatusEnum;
	}
	
	public boolean isResponseCheck() {
		
		ResponseCall responseCall = new ResponseCall();
		
		boolean isResponseCheck = responseCall.isResponseCalling();
		
		return isResponseCheck;
	}
	
	public boolean isCheckHangUp(String string) {
		String regExpQuit = "[qQ]";
		
		if (string.matches(regExpQuit)) {
			return true;
		}
			
		return false;
	}
	
	public boolean isCheckNumber(String string) {
		String regExp = "(02|031|032|033|041|042|043|044|051|052|053|054|055|061|062|063|064|010|070)\\d{3,4}\\d{4}";
		
		if (string.matches(regExp)) {
			
			return true;
		}
			
		return false;
	}
}
