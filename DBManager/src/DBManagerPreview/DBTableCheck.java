package DBManagerPreview;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DBTableCheck {

	public void checkTable(Statement stmt) {
		try {
			DBTableParser dbTableParser = new DBTableParser();
			List<DBTableDTO> dbTableList = new ArrayList<DBTableDTO>();
			dbTableList = dbTableParser.xmlParser();
			executeQuery(stmt, dbTableList);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void executeQuery(Statement stmt, List<DBTableDTO> dbTableList) {
		for (DBTableDTO dbTableDTO : dbTableList) {
//			System.out.println("index: " + dbTableList.indexOf(dbTableDTO) + "\n" + 
//					"name: " + dbTableDTO.getName() + "\n" + 
//					"query: " + dbTableDTO.getQuery());
			String name = dbTableDTO.getName();
			String query = dbTableDTO.getQuery();
			try {
				boolean result = stmt.execute(query);
//				System.out.println("result: " + result);
				if (!result) {
					System.out.println("[EXECUTE QUERY] " + "\n" + query + 
							"\n" + "Query executed successfully." + "\n");
				}
			} catch (SQLException e) {
				String result = e.getMessage() + "\n";
				result = result.replace("ERROR: relation", "[CHECK QUERY]");
				System.out.println(result);
//				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		}
	}
	
}
