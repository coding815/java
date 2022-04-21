package com.junit.test.parser;

import org.junit.Test;

public class ClusterStatusParserTest {
	private static final int CLUSTER_STATUS_NAME = 1;
	private static final int CLUSTER_STATUS_STAUTS = 2;
	private static final int CLUSTER_STATUS_NODES = 3;
	private static final int CLUSTER_STATUS_SERVICES = 4;
	private static final int CLUSTER_STATUS_DESCRIPTION = 5;
	
	@Test
	public void clusterStatusParserTest() throws Exception {
		
		String name 			= "";
		String status	 		= "";
		String nodes 			= "";
		String services  		= "";
		String description 		= "";
			
		String tempHaclusterStatusCommand = "== Cluster status ==\n" + 
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
		
		String[] paragraphSplit = tempHaclusterStatusCommand.split("\n\n");
		
		for (String paragraphStr : paragraphSplit) {
					
			if (!paragraphStr.contains("Cluster status ")) {
				continue;
			}
			
			System.out.println("paragraphStr :");
			System.out.println(paragraphStr);

			String[] lineSplit = tempHaclusterStatusCommand.split("\n");
	
			for (String lineStr : lineSplit) {
				
				if (!lineStr.contains("hacluster")) {
					continue;
				}
				
				System.out.println("lineStr :" + lineStr);
				System.out.println("");
				
				String[] blankSplit = lineStr.split("\\s+");
	
				for (int i =0; i < blankSplit.length; i++) {
					System.out.println("blankStr[" + i + "]: " + blankSplit[i]);
					
					switch (i) {
					case CLUSTER_STATUS_NAME: 				// 1
						name = blankSplit[i];
						break;
					case CLUSTER_STATUS_STAUTS:				// 2
						status = blankSplit[i];
						break;
					case CLUSTER_STATUS_NODES: 				// 3
						nodes = blankSplit[i];
						break;
					case CLUSTER_STATUS_SERVICES: 			// 4
						services = blankSplit[i];
						break;
					case CLUSTER_STATUS_DESCRIPTION: 		// 5
						description = blankSplit[i];
						break;
					default:
						break;
					}
				}
			}
		}
	}
}

