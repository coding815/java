package button;

import java.util.Scanner;

public class Button {

	public String pressButton() {
		
		Scanner scanner = new Scanner(System.in);
		
		ButtonModel buttonModel = new ButtonModel();
		
		String inputButtonString = buttonModel.pressButton;
		
		inputButtonString = "";
		
		System.out.print("��ư�� �����ϴ�.: ");
		
		inputButtonString = scanner.next();
		
		return inputButtonString;
	}
}
