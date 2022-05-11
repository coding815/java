package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableTest {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://10.180.93.64:5432/skt_dev_tmp";
		String user = "epc";
		String password = "epc";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
				System.out.println("Connected to the database !!!");
				
				String query = "CREATE TABLE public.alarm (\n" + 
						"	logid numeric NULL DEFAULT 0,\n" + 
						"	nodeid numeric NULL DEFAULT 0,\n" + 
						"	specificproblem varchar(500) NULL DEFAULT ''::character varying,\n" + 
						"	severity varchar(10) NULL DEFAULT ''::character varying,\n" + 
						"	managedobject varchar(100) NULL DEFAULT ''::character varying,\n" + 
						"	\"location\" varchar(200) NULL DEFAULT ''::character varying,\n" + 
						"	hostname varchar(64) NULL DEFAULT ''::character varying,\n" + 
						"	netype int4 NULL DEFAULT 0,\n" + 
						"	alarmcode varchar(20) NULL DEFAULT ''::character varying,\n" + 
						"	additionalmsg varchar(4000) NULL DEFAULT ''::character varying,\n" + 
						"	ackuser varchar(16) NULL DEFAULT ''::character varying,\n" + 
						"	acktime numeric NULL DEFAULT 0,\n" + 
						"	ackstate varchar(100) NULL DEFAULT ''::character varying,\n" + 
						"	alarmtime numeric NULL DEFAULT 0,\n" + 
						"	hmieventtime numeric NULL DEFAULT 0,\n" + 
						"	alarmid varchar(50) NULL DEFAULT ''::character varying,\n" + 
						"	recoverytime numeric NULL DEFAULT 0,\n" + 
						"	uuid varchar(64) NULL DEFAULT ''::character varying,\n" + 
						"	switch_name varchar(32) NULL DEFAULT ''::character varying,\n" + 
						"	switch_port varchar(32) NULL DEFAULT ''::character varying\n" + 
						");"
						+ "\n" + 
						"CREATE INDEX idx_alarm_01 ON alarm USING btree (alarmid);\n" + 
						"CREATE INDEX idx_alarm_02 ON alarm USING btree (location);\n" + 
						"CREATE INDEX idx_alarm_03 ON alarm USING btree (recoverytime);\n" + 
						"CREATE INDEX idx_alarm_04 ON alarm USING btree (hmieventtime);\n" + 
						"CREATE INDEX idx_alarm_05 ON alarm USING btree (alarmtime);"
						;
				
//				String query = "            CREATE TABLE tb_test (\n" + 
//						"                id numeric NOT NULL,\n" + 
//						"                name varchar(24) NOT NULL,\n" + 
//						"                PRIMARY KEY (id)\n" + 
//						"            );";
				
//				String query = "SELECT * FROM tb_test";
				
				Statement stmt = conn.createStatement();
				boolean result = stmt.execute(query);
				
				System.out.println("result: " + result);
				
//				if (result) {
//					System.out.println("Failed to create table.");
//				} else {
//					System.out.println("Table is created successfully.");
//				}
				
//				int resultInt = stmt.executeUpdate(query);
//				System.out.println("resultInt: " + resultInt);

				stmt.close();
				conn.close();
			} else {
				System.out.println("Failed to make connection ...");
			}
		} catch (ClassNotFoundException e) {
			System.err.format("Failed to load postgresql driver.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
