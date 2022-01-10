package connector;

public class Connector {
	ConnectorStatusEnum connectorStatusEnum = ConnectorStatusEnum.DISCONNECTED;
	
	public boolean isCheckConnected() {
		boolean isConnected;
		isConnected = connectorStatusEnum.getIsConnected();
		return isConnected;
	}
	
}
