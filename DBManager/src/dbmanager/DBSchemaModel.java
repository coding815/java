package dbmanager;

import java.util.List;

public class DBSchemaModel {
	
	List<DBSchemaTableDTO> dbSchemaTableList;	
	List<DBSchemaSqlDTO> dbSchemaSqlList;
	
	public List<DBSchemaTableDTO> getDbSchemaTableList() {
		return dbSchemaTableList;
	}
	public void setDbSchemaTableList(List<DBSchemaTableDTO> dbSchemaTableList) {
		this.dbSchemaTableList = dbSchemaTableList;
	}
	public List<DBSchemaSqlDTO> getDbSchemaSqlList() {
		return dbSchemaSqlList;
	}
	public void setDbSchemaSqlList(List<DBSchemaSqlDTO> dbSchemaSqlList) {
		this.dbSchemaSqlList = dbSchemaSqlList;
	}
	
}

