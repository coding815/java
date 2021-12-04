package lottostore;

import java.util.Arrays;

public class LottoGenerator {
	private static final int LOTTO_ARRAY_COUNT = 6;
	private static final int LOTTO_MAX_NUMBER = 45;
	
	public void generateLotto(int coin) {
		
		for (int i = 0; i < coin; i++) {

			int[] lottoArray = new int[LOTTO_ARRAY_COUNT];
			
			int lottoArrayIndex = 0;
			
			for (int j = 0; j < LOTTO_ARRAY_COUNT; j++) {
				int lottoNumber = createRandomLottoNumber();
//				System.out.println("lottoNumber: " + lottoNumber);
				boolean existLottoNumber = checkLottoNumberOverlap(lottoArray, lottoNumber);
				
				if (existLottoNumber == false) {
					lottoArray[lottoArrayIndex] = lottoNumber;
					lottoArrayIndex++;
				} else {
					j--;
				}
			}
					
			Arrays.sort(lottoArray);
			
			System.out.print("<Game " + (i + 1) + "> ");
			
			for (int j : lottoArray) {
				System.out.print("[" + j + "] ");
			}
			
			System.out.println("");
		}
	}

	public boolean checkLottoNumberOverlap(int[] lottoArray, int lottoNumber) {
		for (int i = 0; i < LOTTO_ARRAY_COUNT; i++) {
			if (lottoArray[i] == lottoNumber) {
				return true;
			}
		}
		return false;
	}
	
	public int createRandomLottoNumber() {
		int randomLottoNumber = 0;
				
		while(randomLottoNumber == 0) {
			double randomValue = Math.random();
			int intValue = (int)(randomValue * LOTTO_MAX_NUMBER) + 1;
//			System.out.println("intValue: " + intValue);
			randomLottoNumber = intValue;
		}
//		System.out.println("randomLottoNumber: " + randomLottoNumber);
		
		return randomLottoNumber;
	}

}
