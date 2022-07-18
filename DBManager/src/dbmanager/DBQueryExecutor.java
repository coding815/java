package dbmanager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DBQueryExecutor {

	private static int addTableCount;
	private static int successQueryCount;
	private static int executeQueryCount;
	private static int failQueryCount;

	public void parseDBSchemaXML(Connection conn, String path) throws SQLException {
		try {
			DBSchemaModel dbConnectModel = new DBSchemaModel();
			DBSchemaXMLParser dbSchemaXMLParser = new DBSchemaXMLParser();

			dbConnectModel = dbSchemaXMLParser.parse(path);
			loadDBSchema(conn, dbConnectModel);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	private void loadDBSchema(Connection conn, DBSchemaModel dbSchemaModel) throws SQLException {

		List<DBSchemaTableDTO> dbSchemaTableList = dbSchemaModel.getDbSchemaTableList();
		List<DBSchemaSqlDTO> dbSchemaSqlList = dbSchemaModel.getDbSchemaSqlList();
		
		// 생성한 날짜 순으로 dbSchemaSqlList 정렬
		dbSchemaSqlList = dbSchemaSqlList.stream()
						.sorted(Comparator.comparing(DBSchemaSqlDTO::getDate))
						.collect(Collectors.toList());

		executeCreateQueryAndAlterQuery(conn, dbSchemaTableList, dbSchemaSqlList);
		executeInsertQuery(conn, dbSchemaTableList, dbSchemaSqlList);

//		printTobeTableCount(dbSchemaTableList);
		printTotalQueryCount();
	}

	private void executeInsertQuery(Connection conn, List<DBSchemaTableDTO> dbSchemaTableList,
			List<DBSchemaSqlDTO> dbSchemaSqlList) throws SQLException {
		for (DBSchemaTableDTO dbSchemaTableDTO : dbSchemaTableList) {
			for (DBSchemaSqlDTO dbSchemaSqlDTO : dbSchemaSqlList) {
				if (dbSchemaTableDTO.getIndex() == dbSchemaSqlDTO.getIndex()) {
					String tableName = dbSchemaTableDTO.getName();
					String sqlQuery = dbSchemaSqlDTO.getTextContent();
					String queryType = dbSchemaSqlDTO.getType();
					if (sqlQuery == null || sqlQuery.isEmpty() || sqlQuery.length() == 0) {
						System.out.println("[FAIL   ] \"" + tableName + "\" table query is not found.\n");
					} else if (queryType.equals(DBSchemaTypeEnum.INSERT.getValue())) {
						if (tableName.equals(DBConnectConstants.DB_SCHEMA_TB_USER_ACCOUNT_COMPLEXITY)) {
							checkInitData(conn, tableName, sqlQuery);
						} else {
							insertQuery(conn, tableName, sqlQuery);
						}
					}
				}
			}
		}
	}

	private void executeCreateQueryAndAlterQuery(Connection conn, List<DBSchemaTableDTO> dbSchemaTableList,
			List<DBSchemaSqlDTO> dbSchemaSqlList) throws SQLException {
		for (DBSchemaTableDTO dbSchemaTableDTO : dbSchemaTableList) {
//			System.out.println("index: " + dbTableList.indexOf(dbTableDTO) + "\n" + 
//					"name: " + dbTableDTO.getName() + "\n" + 
//					"query: " + dbTableDTO.getQuery());
			for (DBSchemaSqlDTO dbSchemaSqlDTO : dbSchemaSqlList) {
				if (dbSchemaTableDTO.getIndex() == dbSchemaSqlDTO.getIndex()) {
					String tableName = dbSchemaTableDTO.getName();
					String sqlQuery = dbSchemaSqlDTO.getTextContent();
					String queryType = dbSchemaSqlDTO.getType();
					if (sqlQuery == null || sqlQuery.isEmpty() || sqlQuery.length() == 0) {
						System.out.println("[EMPTY QUERY] \"" + tableName + "\" table query is not found.\n");
					} else if (queryType.equals(DBSchemaTypeEnum.CREATE.getValue())
							|| queryType.equals(DBSchemaTypeEnum.ALTER.getValue())) {
						executeQuery(conn, tableName, sqlQuery);
//						checkAlterQuery(conn, tableName, sqlQuery);
					}
				}
			}
		}
	}

	private void printTotalQueryCount() {
		int totalQueryCount = successQueryCount + executeQueryCount + failQueryCount;
		System.out.println("\n############# TOTAL QUERY COUNT: " + totalQueryCount + " #############");
		System.out.println("SUCCESS: " + successQueryCount + ", EXECUTE: " + executeQueryCount
				+ ", FAIL   : " + failQueryCount + "\n");
	}

	private void printTobeTableCount(List<DBSchemaTableDTO> dbSchemaTableList) {
		int asisTableCount = dbSchemaTableList.size();
		int tobeTableCount = asisTableCount + addTableCount;
		System.out.println("############# TO-BE TABLE COUNT: " + tobeTableCount + " #############\n");
	}

	private void checkInitData(Connection conn, String tableName, String sqlQuery) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		String selectQuery = DBConnectConstants.DB_SCHEMA_SELECT_FROM_TB_USER_ACCOUNT_COMPLEXIT;

		ResultSet rs = stmt.executeQuery(selectQuery);
		rs.last();
		int rowCount = rs.getRow();
//		System.out.println("rowCount: " + rowCount);

		if (rowCount < 1) {
//			String sqlQuery = "INSERT INTO tb_user_account_complexity VALUES (6, 14, 8, 14, 0, 0, 0, 0, NULL, 200, 0);";

			try {
				int insertCount = stmt.executeUpdate(sqlQuery);
				System.out.println("insertCount: " + insertCount);
				if (insertCount > 0) {
					_executeQuery(tableName, sqlQuery);
				}
			} catch (SQLException e) {
				String result = e.getMessage();
				result = catchQuery(tableName, result);
				System.out.println(result);
			}
		} else {
			System.out.println(DBConnectConstants.DB_SCHEMA_TB_USER_ACCOUNT_COMPLEXITY_INIT_DATA_ALREADY_EXIST);
		}

		if (stmt != null) {
			stmt.close();
		}
	}

	private void checkAlterQuery(Connection conn, String tableName, String sqlQuery) throws SQLException {
		Statement stmt = conn.createStatement();

		String query = "select \n" + 
				"	column_name,\n" + 
				"	data_type,\n" + 
				"	character_maximum_length,\n" + 
				"	is_nullable,\n"	+
				"	column_default\n" +
				"from\n" + 
				"	information_schema.columns\n" + 
				"where \n" + 
				"	table_name = 'tb_test_one'\n" + 
				"and \n" + 
				"	column_name = 'user_id';";

//		String query = "select * from tb_user_account_complexity;";

		ResultSet rs = stmt.executeQuery(query);

		int rowCount = rs.getRow();

		if (rowCount < 1) {

		}

		while (rs.next()) {
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + 
					rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5));
		}

		if (stmt != null) {
			stmt.close();
		}
	}

	private void insertQuery(Connection conn, String tableName, String sqlQuery) throws SQLException {
		Statement stmt = conn.createStatement();
		
		String[] semicolonSplit = sqlQuery.split(";");
		for (String insertQuery : semicolonSplit) {
			insertQuery = insertQuery + ";";
			try {
				boolean result = stmt.execute(insertQuery);
	//				System.out.println("result: " + result);
				if (!result) {
					_executeQuery(tableName, insertQuery);
				}
			} catch (SQLException e) {
				String result = e.getMessage();
				result = catchQuery(tableName, result);
				System.out.println(result);
			}
		}
		
		if (stmt != null) {
			stmt.close();
		}
	}
	
	private void executeQuery(Connection conn, String tableName, String sqlQuery) throws SQLException {
		Statement stmt = conn.createStatement();

		try {
			boolean result = stmt.execute(sqlQuery);
//				System.out.println("result: " + result);
			if (!result) {
				_executeQuery(tableName, sqlQuery);
				addCreateTableCount(sqlQuery);
			}
		} catch (SQLException e) {
			String result = e.getMessage();
			result = catchQuery(tableName, result);
			System.out.println(result);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private String catchQuery(String tableName, String result) {
		if (result.contains("relation") || result.contains("duplicate")) {
			result = existTable(result);
		} else {
			result = failQuery(tableName, result);
		}
		return result;
	}

//	private String existQuery(String tableName, String result) {
//		result = result.replace("\"", "\'");
//		result = result.replace("ERROR:", "[SUCCESS] \"" + tableName + "\"");
//		result = result.replace("does not exist", "already changed.\n");
//		successQueryCount++;
//		return result;
//	}

	private String failQuery(String tableName, String result) {
		result = result.replace("\"", "\'");
		result = result.replace("ERROR:", "[FAIL   ] \"" + tableName + "\"");
		result = result.replace("exist", "exist.");
		result = result.replace("\n", " -");
		failQueryCount++;
		return result;
	}

	private String existTable(String result) {
		result = result.replace("ERROR:", "[SUCCESS]");
		result = result.replace("\n", " ");
		result = result + ".";
		result = result.replace("..", ".");
		successQueryCount++;
		return result;
	}

	private void addCreateTableCount(String sqlQuery) {
		if (sqlQuery.toUpperCase().contains("CREATE")) {
			addTableCount++;
		}
	}

	private void _executeQuery(String tableName, String sqlQuery) {
		StringBuilder sb = new StringBuilder();

		sb.append("[SUCCESS] \"");
		sb.append(tableName);
		sb.append("\"\n");
		sb.append(sqlQuery);
		sb.append("\nQuery executed successfully.");

		System.out.println(sb);

		executeQueryCount++;
	}

}
