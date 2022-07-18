package dbmanager;

public enum DBSchemaTypeEnum {
	CREATE("CREATE"),		
	ALTER("ALTER"),
	INSERT("INSERT"),
	;
	
	private String value;
	
	DBSchemaTypeEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}

