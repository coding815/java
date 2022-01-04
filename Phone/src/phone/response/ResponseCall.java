package phone.response;

import java.util.concurrent.TimeUnit;

public class ResponseCall {
	
	public boolean isResponseCalling() {
		
		try {
			for (int i = 0; i < 5; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("### dda r r r rng !!! ###");
				
				int randomResponseSetting = randomResponseSetting();
				
				if (randomResponseSetting == 10) {
					System.out.println("##### hello?! #####");
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public int randomResponseSetting() {
		int randomResponseSetting = 0;
				
		while(randomResponseSetting == 0) {
			double randomValue = Math.random();
			int intValue = (int)(randomValue * 10) + 1;
//			System.out.println("intValue: " + intValue);
			randomResponseSetting = intValue;
		}
		System.out.println("randomResponseSetting: " + randomResponseSetting);
		
		return randomResponseSetting;
	}
}
