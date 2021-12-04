package lottostore;

import lottostore.chair.Chair;
import lottostore.chair.ChairStateEnum;
import lottostore.table.Table;
import lottostore.table.TableStateEnum;

public class TableState {
	private static final int TOTAL_CHAIR_NUMBER = 4;
	
	public void checkTableAndChairState() {
		Table table = new Table();

		Chair chair1 = new Chair();
		Chair chair2 = new Chair();
		Chair chair3 = new Chair();
		Chair chair4 = new Chair();
		
		chair1.setChairState(ChairStateEnum.OCCUPIED);
		chair2.setChairState(ChairStateEnum.OCCUPIED);
		chair3.setChairState(ChairStateEnum.OCCUPIED);
		chair4.setChairState(ChairStateEnum.EMPTY);
		
		int checkTableOccupied = 0;
		
		if (chair1.getChairState() != ChairStateEnum.EMPTY) {
			checkTableOccupied++;
		}
		if (chair2.getChairState() != ChairStateEnum.EMPTY) {
			checkTableOccupied++;
		}
		if (chair3.getChairState() != ChairStateEnum.EMPTY) {
			checkTableOccupied++;
		}
		if (chair4.getChairState() != ChairStateEnum.EMPTY) {
			checkTableOccupied++;
		}
		
		System.out.println("checkTableOccupied: " + checkTableOccupied);
		
		switch(checkTableOccupied) {
			case 0: 
				table.setTableState(TableStateEnum.EMPTY);
				break;
			case 1: 
				table.setTableState(TableStateEnum.QUARTER_OCCUPIED);
				break;
			case 2: 
				table.setTableState(TableStateEnum.HALF_OCCUPIED);
				break;
			case 3: 
				table.setTableState(TableStateEnum.THREE_QUARTERS_OCCUPIED);
				break;
			case 4: 
				table.setTableState(TableStateEnum.THREE_QUARTERS_OCCUPIED);
				break;
			default:
				table.setTableState(TableStateEnum.EMPTY);
		}
		
		System.out.println("TABLE STATE: " + table.getTableState().getValue());
		System.out.println("CHAIR STATE: " + checkTableOccupied + "/" + TOTAL_CHAIR_NUMBER + " USED");
	}

}
