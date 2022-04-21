package com.junit.test.parser;

import org.junit.Test;

public class EFAServiceStatusParserTest {
	
	private static final int EFA_SERVICE_STATUS_NAME = 0;
	private static final int EFA_SERVICE_STATUS_READY = 1;
	private static final int EFA_SERVICE_STATUS_STATUS = 2;
	private static final int EFA_SERVICE_STATUS_RESTARTS = 3;
	private static final int EFA_SERVICE_STATUS_AGE = 4;
	private static final int EFA_SERVICE_STATUS_IPADDRESS = 5;
	private static final int EFA_SERVICE_STATUS_NODE = 6;
	private static final int EFA_SERVICE_STATUS_NOMINATED_NODE = 7;
	private static final int EFA_SERVICE_STATUS_READINESS_GATES = 8;
	
	@Test
	public void efaServiceStatusParserTest() throws Exception {
		
		String nodeName 		= "";
		String ready	 		= "";
		String status 			= "";
		String restarts 		= "";
		String ipaddress  		= "";
		String age	 			= "";
		String node 			= "";
		String nominatedNode	= "";
		String readinessGates	= "";
			
		String efaCommandResult = " k3s kubectl get pod -nefa -o wide\n" + 
				"NAME                           READY   STATUS     RESTARTS   AGE   IP              NODE    NOMINATED NODE   READINESS GATES\n" + 
				"gofabric-service-5vkwg         0/1     Init:0/2   2          20d   10.42.1.78      tpvm2   <none>           <none>\n" + 
				"goauth-service-6mmdf           0/1     Init:0/2   2          20d   10.42.1.79      tpvm2   <none>           <none>\n" + 
				"goinventory-service-vg4rl      0/1     Init:0/2   2          20d   10.42.1.81      tpvm2   <none>           <none>\n" + 
				"gosnmp-service-sqnj4           0/1     Init:0/1   3          20d   60.30.181.100   tpvm2   <none>           <none>\n" + 
				"govcenter-service-962pd        0/1     Init:0/2   2          20d   10.42.1.82      tpvm2   <none>           <none>\n" + 
				"gorbac-service-qq78p           0/1     Init:0/2   2          20d   10.42.1.83      tpvm2   <none>           <none>\n" + 
				"gohyperv-service-jw2hc         0/1     Init:0/2   3          20d   10.42.1.84      tpvm2   <none>           <none>\n" + 
				"efa-api-docs-lx7gh             1/1     Running    3          20d   10.42.1.87      tpvm2   <none>           <none>\n" + 
				"gosystem-service-hnx8w         1/1     Running    2          20d   10.42.1.85      tpvm2   <none>           <none>\n" + 
				"gonotification-service-fqjcl   0/1     Init:0/2   2          20d   60.30.181.100   tpvm2   <none>           <none>\n" + 
				"goraslog-service-gq2rf         0/1     Init:0/3   3          20d   60.30.181.100   tpvm2   <none>           <none>\n" + 
				"goopenstack-service-5bfwx      0/1     Init:0/1   2          20d   10.42.1.86      tpvm2   <none>           <none>\n" + 
				"gotenant-service-gsfft         0/1     Init:0/3   3          20d   10.42.1.88      tpvm2   <none>           <none>\n" + 
				"rabbitmq-pqpm2                 0/1     Init:0/1   4          20d   10.42.1.89      tpvm2   <none>           <none>\n" + 
				"gosnmp-service-tdmrs           1/1     Running    2          20d   60.30.181.99    tpvm1   <none>           <none>\n" + 
				"gosystem-service-qfh6s         1/1     Running    3          20d   10.42.0.63      tpvm1   <none>           <none>\n" + 
				"efa-api-docs-mknnp             1/1     Running    2          20d   10.42.0.64      tpvm1   <none>           <none>\n" + 
				"goopenstack-service-mz5nt      1/1     Running    2          20d   10.42.0.67      tpvm1   <none>           <none>\n" + 
				"rabbitmq-b69kj                 1/1     Running    2          20d   10.42.0.62      tpvm1   <none>           <none>\n" + 
				"gorbac-service-5zhkd           1/1     Running    1          20d   10.42.0.69      tpvm1   <none>           <none>\n" + 
				"goauth-service-zfr8x           1/1     Running    1          20d   10.42.0.66      tpvm1   <none>           <none>\n" + 
				"gohyperv-service-42grt         1/1     Running    1          20d   10.42.0.68      tpvm1   <none>           <none>\n" + 
				"govcenter-service-9g7nw        1/1     Running    2          20d   10.42.0.65      tpvm1   <none>           <none>\n" + 
				"gofabric-service-t8wvc         1/1     Running    1          20d   10.42.0.59      tpvm1   <none>           <none>\n" + 
				"goraslog-service-4zdhq         1/1     Running    1          20d   60.30.181.99    tpvm1   <none>           <none>\n" + 
				"gotenant-service-24wlb         1/1     Running    1          20d   10.42.0.61      tpvm1   <none>           <none>\n" + 
				"gonotification-service-vqhfd   1/1     Running    1          20d   60.30.181.99    tpvm1   <none>           <none>\n" + 
				"goinventory-service-6cx7r      1/1     Running    14         20d   10.42.0.60      tpvm1   <none>           <none>\n" + 
				"";

		String trimResult = efaCommandResult.trim();
		
		String[] lineSplit = trimResult.split("\n");

		for (String lineStr : lineSplit) {
			
			if (lineStr.contains("kubectl") || lineStr.contains("Name") || lineStr.contains("tpvm2") ) {
				continue;
			}
			
			System.out.println("");
			System.out.println("lineStr :" + lineStr);
			
			String[] blankSplit = lineStr.split("\\s+");

			for (int i =0; i < blankSplit.length; i++) {
//				System.out.print("blankSplit[" + i + "]: " + blankSplit[i] + ", ");
				
				switch (i) {
				case EFA_SERVICE_STATUS_NAME: 						// 1
					String trimStr = blankSplit[i].trim();
					String subStr = trimStr.substring(0, 2);
					if (subStr.equals("go")) {
						nodeName = trimStr.replaceFirst("go", "");
					} else {
						nodeName = trimStr;
					}
					System.out.println("nodeName: " + nodeName);
					break;
				case EFA_SERVICE_STATUS_READY:						// 2
					ready = blankSplit[i].trim();
					System.out.println("ready: " + ready);
					break;
				case EFA_SERVICE_STATUS_STATUS: 					// 3
					status = blankSplit[i].trim();
					System.out.println("status: " + status);
					break;
				case EFA_SERVICE_STATUS_RESTARTS:					// 4
					restarts = blankSplit[i].trim();
					System.out.println("restarts: " + restarts);
					break;
				case EFA_SERVICE_STATUS_AGE: 						// 5
					age = blankSplit[i].trim();
					System.out.println("age: " + age);
					break;
				case EFA_SERVICE_STATUS_IPADDRESS: 					// 6
					ipaddress = blankSplit[i].trim();
					System.out.println("ipaddress: " + ipaddress);
					break;
				case EFA_SERVICE_STATUS_NODE:						// 7
					node = blankSplit[i].trim();
					System.out.println("node: " + node);
					break;
				case EFA_SERVICE_STATUS_NOMINATED_NODE: 			// 8
					nominatedNode = blankSplit[i].trim();
					System.out.println("nominatedNode: " + nominatedNode);
					break;
				case EFA_SERVICE_STATUS_READINESS_GATES: 			// 9
					readinessGates = blankSplit[i].trim();
					System.out.println("readinessGates: " + readinessGates);
					break;
				default:
					break;
				}
			}
		}
	}
}

