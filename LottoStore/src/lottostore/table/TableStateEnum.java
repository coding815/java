package lottostore.table;

public enum TableStateEnum implements TableStateEnumService {
	EMPTY(0, "EMPTY"), 
	QUARTER_OCCUPIED(1, "QUARTER OCCUPIED"), 
	HALF_OCCUPIED(2, "HALF OCCUPIED"),
	THREE_QUARTERS_OCCUPIED(3, "THREE QUARTERS OCCUPIED"),
	FULL_OCCUPIED(4, "FULL OCCUPIED");
	
	private final int index;
	private final String state;

	TableStateEnum(int index, String state) {
		this.index = index;
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public static TableStateEnum getValue(int index) {
		for (TableStateEnum enumObj : TableStateEnum.values()) {
			if (enumObj.getIndex() == index) {
				return enumObj;
			}
		}

		return EMPTY;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public String getValue() {
		return state;
	}
}
