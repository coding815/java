package dbmanager;

public class DBConnectConstants {
	
	public static final String DB_CONNECT_DRIVER = "org.postgresql.Driver";
	
	public static final String JBOSS_CONFIGURATION_PATH = "NmfFileSys/ericsson/3pp/jboss/standalone/configuration";
	public static final String STANDALONE_NMF_FILE = "standalone-nmf.xml";
	
	public static final String DB_CONNECT_URL = "jdbc:postgresql://10.180.93.64:5432/skt_dev_tmp";	// standalone-nmf
	public static final String DB_CONNECT_USER = "epc";	// mmc
	public static final String DB_CONNECT_PASSWORD = "epc";	//mmc
	
	public static final String DB_SCHEMA_LOCATION = "/home/zjeokwa/git/SKT_NMF/NmfServer/ERLGNmfServer/src/main/resources/db_schema.xml";

	public static final String DB_SCHEMA_TB_USER_ACCOUNT_COMPLEXITY = "tb_user_account_complexity";
	public static final String DB_SCHEMA_SELECT_FROM_TB_USER_ACCOUNT_COMPLEXIT = "SELECT * FROM tb_user_account_complexity;";
	public static final String DB_SCHEMA_TB_USER_ACCOUNT_COMPLEXITY_INIT_DATA_ALREADY_EXIST = "[SUCCESS] tb_user_account_complexity init data already exists.";
	
	public static final String DB_SCHEMA_TYPE_CREATE = "CREATE";
	public static final String DB_SCHEMA_TYPE_ALTER = "ALTER";
	public static final String DB_SCHEMA_TYPE_INSERT = "INSERT";
	
}
