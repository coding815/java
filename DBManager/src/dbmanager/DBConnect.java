package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnect {
	INSTANCE;

	public void connect(String path) {
		
        String host = DBConnectConfig.INSTANCE.get(DBConnectConfig.Key.DB_HOST);
        int port = Integer.parseInt(DBConnectConfig.INSTANCE.get(DBConnectConfig.Key.DB_PORT));
        String name = DBConnectConfig.INSTANCE.get(DBConnectConfig.Key.DB_NAME);
        
        String driver = DBConnectConstants.DB_CONNECT_DRIVER;
		String url = "jdbc:postgresql://" + host + ":" + port + "/" + name;
        String user = DBConnectConfig.INSTANCE.get(DBConnectConfig.Key.DB_USER);
        String password = DBConnectConfig.INSTANCE.get(DBConnectConfig.Key.DB_PWD);
        
        System.out.println(String.format("===== DB Connection Information =====\n"
        		+ "DRIVER: %s\n HOST: %s | PORT: %d | DATABASE: %s | ID: %s | PWD: %s", 
        		driver, host, port, name, user, password));
		
//		String driver = DBConnectConstants.DB_CONNECT_DRIVER;
//		String url = DBConnectConstants.DB_CONNECT_URL;
//		String user = DBConnectConstants.DB_CONNECT_USER;
//		String password = DBConnectConstants.DB_CONNECT_PASSWORD;
		
		System.out.println("");
		try {
			_connect(path, driver, url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("=====================================");
			System.out.println("= Failed to load postgresql driver. =");
			System.out.println("=====================================");
			System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("==============================");
			System.out.println("= Failed to make connection. =");
			System.out.println("==============================");
			System.out.println("");
		}
	}

	private void _connect(String path, String driver, String url, String user, String password) 
			throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, user, password);
		try {
			System.out.println("=================================================");
			System.out.println("= The connection to the database is successful. =");
			System.out.println("=================================================");
			System.out.println("");
			
			DBQueryExecutor dbQueryExecutor = new DBQueryExecutor();
			dbQueryExecutor.parseDBSchemaXML(conn, path);		

			System.out.println("=============================================");
			System.out.println("= The connection to the database is closed. =");
			System.out.println("=============================================");
			System.out.println("");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
