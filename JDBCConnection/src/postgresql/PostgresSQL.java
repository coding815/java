package postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSQL {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		String connUrl = "jdbc:postgresql://10.180.93.60:5432/nmf";
		String user = "epc";
		String password = "epc";
		
//		try
//		{
//			Connection connect = null;
//			connect = DriverManager.getConnection(connUrl, user, password);
//			if (connect != null) {
//				System.out.println("Connection successful!!!");
//
//			} else {
//				System.out.println("no connection...");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		try (Connection conn = DriverManager.getConnection(connUrl, user, password);) {
			if (conn != null) {
				System.out.println("Connected to the database !!!");
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM tb_node_info");
				
				while (rs.next()) {
					int nodeType = rs.getInt("node_type");
					String nodeName = rs.getString("node_name");
					String ipaddress = rs.getString("ipaddress");
					
					System.out.println("node_type: " + nodeType + ", " +
							"node_name: " + nodeName + ", " +
							"ipaddress: " + ipaddress);
				}
				
				rs.close();
				stmt.close();
				conn.close();
			} else {
				System.out.println("Failed to make connection ...");
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}