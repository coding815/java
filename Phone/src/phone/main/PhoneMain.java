package phone.main;

import phone.sender.Sender;
import phone.status.PhoneStatusEnum;

public class PhoneMain {
	
	public static void main(String[] args) {
		PhoneStatusEnum phoneStatusEnum = PhoneStatusEnum.NORMAL;
		
		while (phoneStatusEnum == PhoneStatusEnum.NORMAL) {
		
			Sender sender = new Sender();
			
			phoneStatusEnum = sender.pickUpPhone();
			System.out.println("phoneStatusEnum: " + phoneStatusEnum);
			
			if (phoneStatusEnum == PhoneStatusEnum.PICKUP) {
				
				phoneStatusEnum = sender.inputPhoneNumbers();
				System.out.println("phoneStatusEnum: " + phoneStatusEnum);
			}
			
			boolean isCheckCall = false;
			
			if (phoneStatusEnum == PhoneStatusEnum.CALLING) {
				isCheckCall = sender.call();
			}
			
			if (isCheckCall == true) {
				System.out.println("not response calling.");
				System.out.println("phoneStatusEnum: " + phoneStatusEnum);
				phoneStatusEnum = PhoneStatusEnum.NORMAL;
				System.out.println("phoneStatusEnum: " + phoneStatusEnum);
			}
		
		}
		
		if (phoneStatusEnum == PhoneStatusEnum.HANGUP) {
			System.out.println("return sender to phone.");
			phoneStatusEnum = PhoneStatusEnum.NORMAL;
			System.out.println("phoneStatusEnum: " + phoneStatusEnum);
		}
	}

}
