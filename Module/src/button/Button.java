package button;

import java.util.Scanner;

public class Button implements ButtonI {

	@Override
	public String pressButton() {
		
		Scanner scanner = new Scanner(System.in);
		
		ButtonModel buttonModel = new ButtonModel();
		
		String inputButtonString = buttonModel.getPressButton();
		
		inputButtonString = "";
		
		System.out.print("버튼을 누릅니다.: ");
		
		inputButtonString = scanner.next();
		
		buttonModel.setPressButton(inputButtonString);
		
		return inputButtonString;
	}

}
