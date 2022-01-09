package button;

import java.util.Scanner;

public class Button {

	public String pressButton() {
		
		Scanner scanner = new Scanner(System.in);
		
		ButtonModel buttonModel = new ButtonModel();
		
		String inputButtonString = buttonModel.pressButton;
		
		inputButtonString = "";
		
		System.out.print("버튼을 누릅니다.: ");
		
		inputButtonString = scanner.next();
		
		return inputButtonString;
	}
}
