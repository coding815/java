package button;

import java.util.Scanner;

public class Button implements ButtonI {

	@Override
	public String pressButton() {
		
		Scanner scanner = new Scanner(System.in);
		
		ButtonModel buttonModel = new ButtonModel();
		
		String inputButtonString = buttonModel.getPressButton();
		
		inputButtonString = "";
		
		System.out.print("��ư�� �����ϴ�.: ");
		
		inputButtonString = scanner.next();
		
		buttonModel.setPressButton(inputButtonString);
		
		return inputButtonString;
	}

}
