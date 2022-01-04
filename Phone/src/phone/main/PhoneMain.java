package phone.main;

import phone.connector.PhoneConnectorEnum;
import phone.sender.Sender;
import phone.status.PhoneStatusEnum;

public class PhoneMain {
	
	public static void main(String[] args) {
		PhoneConnectorEnum phoneConnectorEnum = PhoneConnectorEnum.DISCONNECTED;
		PhoneStatusEnum phoneStatusEnum = PhoneStatusEnum.NORMAL;

		while (phoneStatusEnum == PhoneStatusEnum.NORMAL) {
		
			Sender sender = new Sender();
			
			phoneStatusEnum = sender.pickUpPhone();
			
			if (phoneStatusEnum == PhoneStatusEnum.WAITING) {
				phoneConnectorEnum = PhoneConnectorEnum.CONNECTED;
				System.out.println("phoneStatusEnum: " + phoneStatusEnum);
				phoneStatusEnum = sender.inputPhoneNumber();
				System.out.println("phoneStatusEnum: " + phoneStatusEnum);
			}
			
			boolean isResponseCheck = false;
			
			if (phoneStatusEnum == PhoneStatusEnum.CALLING) {
				isResponseCheck = sender.isResponseCheck(); 
			}
			
			if (isResponseCheck == true) {
				System.out.println("### not respond calling. ###");
				phoneStatusEnum = PhoneStatusEnum.NORMAL;
			}
		
		}
		
		if (phoneStatusEnum == PhoneStatusEnum.HANGUP) {
			System.out.println("### hang up the phone. ###");
			phoneStatusEnum = PhoneStatusEnum.NORMAL;
			phoneConnectorEnum = PhoneConnectorEnum.DISCONNECTED;
			System.out.println("phoneStatusEnum: " + phoneStatusEnum);
			System.out.println("phoneConnectorEnum: " + phoneConnectorEnum);
		}
	}

}
