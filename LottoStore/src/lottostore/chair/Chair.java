package lottostore.chair;

import lottostore.table.Table;

public class Chair extends Table {
	ChairStateEnum chairState;
	
	// getter
	public ChairStateEnum getChairState() {
		return chairState;
	}
	
	// setter
	public void setChairState(ChairStateEnum chairState) {
		this.chairState = chairState;
	}
}
