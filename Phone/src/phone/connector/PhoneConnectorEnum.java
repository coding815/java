package phone.connector;

public enum PhoneConnectorEnum {
	CONNECTED(true),
	DISCONNECTED(false);
	
	private final boolean isConnected;
	
	PhoneConnectorEnum(boolean isConnected) {
		this.isConnected = isConnected;
	} 

	public boolean getIsConnected() {
		return isConnected;
	}
	
}
