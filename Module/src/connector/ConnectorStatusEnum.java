package connector;

public enum ConnectorStatusEnum {
	CONNECTED(true),
	DISCONNECTED(false);
	
	private final boolean isConnected;
	
	ConnectorStatusEnum(boolean isConnected) {
		this.isConnected = isConnected;
	} 

	public boolean getIsConnected() {
		return isConnected;
	}
}
