package connector;

public class Connector {
	
	public boolean isCheckConnected(ConnectorStatusEnum connectorStatusEnum) {
		boolean isConnected;
		isConnected = connectorStatusEnum.getIsConnected();
		return isConnected;
	}
	
}
