package lotto;

public class LottoMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LottoGenerator lottoGenerator = new LottoGenerator();
		
		System.out.println("$ $ $ $ $ $ LOTTO GENERATOR $ $ $ $ $ $");
		
		int coin = 10;
			
		lottoGenerator.generateLotto(coin);
		
		System.out.println("$ $ $ $ $ $ GENERATOR EXIT $ $ $ $ $ $");
	}
	
}
