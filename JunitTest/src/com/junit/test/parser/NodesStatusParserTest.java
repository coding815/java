package com.junit.test.parser;

import org.junit.Test;

public class NodesStatusParserTest {
	private static final int NODES_STATUS_NODE = 1;
	private static final int NODES_STATUS_STATUS = 2;
	private static final int NODES_STATUS_SERVICES = 3;
	private static final int NODES_STATUS_ADDRESS = 4;
	private static final int NODES_STATUS_HOSTID = 5;
	private static final int NODES_STATUS_RELEASE = 6;
	
	@Test
	public void nodesStatusParser() throws Exception {
		
		String node 			= "";
		String status	 		= "";
		String services 			= "";
		String ipaddress 		= "";
		String host_id 			= "";
		String node_release 	= "";
			
		String tempPoolListCommand = "== Cluster status ==\n" + 
				" NAME       STATUS  NODES  SERVICES  DESCRIPTION\n" + 
				" hacluster  ok      2/2    1/1       HA-cluster\n" + 
				"\n" + 
				"== Cluster configuration ==\n" + 
				" FC MONITORING  SERIAL HEARTBEATS ENABLED  NETWORK MONITORING\n" + 
				" no             no                         yes\n" + 
				"\n" + 
				"== Nodes ==\n" + 
				" NODE           STATUS  SERVICES  ADDRESS       HostId    Release\n" + 
				" NexentaStor-1  up      0/1       60.30.180.42  b9675dcc  5.3.0.22\n" + 
				" NexentaStor-2  up      1/1       60.30.180.43  351c5d18  5.3.0.22\n" + 
				"\n" + 
				"CLI@NexentaStor-2>";

		String[] lineSplit = tempPoolListCommand.split("\n");

		for (String lineStr : lineSplit) {
			
			if (!lineStr.contains("NexentaStor") || lineStr.contains("CLI@")) {
				continue;
			}
			
			System.out.println("lineStr :" + lineStr);
			System.out.println("");
			
			String[] blankSplit = lineStr.split("\\s+");

			for (int i =0; i < blankSplit.length; i++) {
				System.out.println("blankStr[" + i + "]: " + blankSplit[i]);
				
				switch (i) {
				case NODES_STATUS_NODE: 				// 1
					node = blankSplit[i];
					break;
				case NODES_STATUS_STATUS:				// 2
					status = blankSplit[i];
					break;
				case NODES_STATUS_SERVICES: 				// 3
					services = blankSplit[i];
					break;
				case NODES_STATUS_ADDRESS: 				// 4
					ipaddress = blankSplit[i];
					break;
				case NODES_STATUS_HOSTID: 				// 5
					host_id = blankSplit[i];
					break;
				case NODES_STATUS_RELEASE:				// 6
					node_release = blankSplit[i];
					break;
				default:
					break;
				}
				

			}
		}
	}
}


