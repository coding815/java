package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public enum DBConnect {
	INSTANCE;

	public void dbConnect() {
		
		String url = "jdbc:postgresql://10.180.93.64:5432/skt_dev_tmp";
		String user = "epc";
		String password = "epc";
		
		System.out.println("\n");
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			executeTableCheck(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("========================================");
			System.out.println("= Failed to load postgresql driver ... =");
			System.out.println("========================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

	private void executeTableCheck(Connection conn) throws SQLException {
		if (conn != null) {
			System.out.println("====================================================");
			System.out.println("= The connection to the database is successful !!! =");
			System.out.println("====================================================");
			System.out.println("\n");
			
			Statement stmt = conn.createStatement();
			
			DBTableCheck dbTableCheck = new DBTableCheck();
			dbTableCheck.checkTable(stmt);		

			stmt.close();
			conn.close();
		} else {
			System.out.println("=================================");
			System.out.println("= Failed to make connection ... =");
			System.out.println("=================================");
			System.out.println("\n");
		}
	}

}
