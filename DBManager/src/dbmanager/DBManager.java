package dbmanager;

public class DBManager {

	public static void main(String[] args) {
//		DBConnect dbConnect = new DBConnect();
//		dbConnect.dbConnect();
		DBConnect.INSTANCE.dbConnect();
	}

}
