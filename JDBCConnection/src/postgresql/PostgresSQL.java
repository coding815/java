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
		
		try
		{
			Connection connect = null;
			connect = DriverManager.getConnection(connUrl, user, password);
			if (connect != null) {
				System.out.println("Connection successful!!!");
//				System.out.println("connect: " + connect);
			} else {
				System.out.println("no connection...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try (Connection connection = DriverManager.getConnection(connUrl, user, password);) {
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT VERSION() AS");
//			
//			while (rs.next()) {
//				String version = rs.getString("version");
//				
//				System.out.println(version);
//			}
//			
//			rs.close();
//			stmt.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}
