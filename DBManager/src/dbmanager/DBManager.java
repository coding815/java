package dbmanager;

public class DBManager {

	public static void main(String[] args) {

		String path = "";
		if(args.length == 0) {
			path = "db_schema.xml";
		} else {
			path = args[0];
		}
		
//		if(args.length == 0) {
//			System.out.println("Usage : java -classpath ... com.ericsson.nmf.tool.db.DBManager ${xmlFile}");
//			System.exit(1);
//		}
//		String path = args[0];
		
		initialize();
		connectDB(path);
	}
	
	private static void initialize() {
		DBConnectConfigSet dbConnectConfigSet = new DBConnectConfigSet();

		try {
			dbConnectConfigSet.loadDBConnectConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void connectDB(String path) {
		DBConnect.INSTANCE.connect(path);
	}

}

