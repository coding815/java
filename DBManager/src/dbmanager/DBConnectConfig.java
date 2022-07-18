package dbmanager;

import java.util.HashMap;
import java.util.Map;

public enum DBConnectConfig {
	INSTANCE;

	private Map<DBConnectConfig.Key, String> configMap = new HashMap<>();

	public enum Key {
		DB_HOST,
		DB_PORT,
		DB_NAME,
		DB_USER,
		DB_PWD,
		;
	}

	public void put(DBConnectConfig.Key key, String value) {
		configMap.put(key, value);
	}

	public String get(DBConnectConfig.Key key) {
		return configMap.get(key);
	}
}
