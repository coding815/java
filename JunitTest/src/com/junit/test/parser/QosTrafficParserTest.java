package com.junit.test.parser;

import org.junit.Test;

public class QosTrafficParserTest {
	private static final int QOS_TRAFFIC_IPADDRESS 	= 1;
	private static final int QOS_TRAFFIC_HOST_NAME 	= 2;
	private static final int QOS_TRAFFIC_COMMAND 	= 4;
	private static final int QOS_TRAFFIC_STATUS 	= 5;
	
	@Test
	public void qosTrafficParserTest() throws Exception {
		
		String ipaddress = "";
		String hostName	 = "";
		String command = "";
		String status  	= "";
		
//		String qosTrafficCommandResult = "efa inventory device execute-cli --ip 30.40.246.5 --command \"show policy-map interface ethernet 0/122\"\n" + 
//				"Execute CLI[failed]\n" + 
//				"+-------------+-----------------+--------+------------------------------------------+--------+---------------------------------------------------+-----------------------------------------------------------+\n" + 
//				"| IP Address  |    Host Name    | Fabric |                 Command                  | Status |                      Reason                       |                          Output                           |\n" + 
//				"+-------------+-----------------+--------+------------------------------------------+--------+---------------------------------------------------+-----------------------------------------------------------+\n" + 
//				"| 30.40.246.5 | Border-Leaf-15A | Magok  | show policy-map interface ethernet 0/122 | Failed | Error found during CLI execution for: 30.40.246.5 | Border-Leaf-15A# show policy-map interface ethernet 0/122 |\n" + 
//				"|             |                 |        |                                          |        |                                                   | ----------------------------------------------------^     |\n" + 
//				"|             |                 |        |                                          |        |                                                   | syntax error: unknown element                             |\n" + 
//				"|             |                 |        |                                          |        |                                                   |                                                           |\n" + 
//				"+-------------+-----------------+--------+------------------------------------------+--------+---------------------------------------------------+-----------------------------------------------------------+\n" + 
//				"Execute CLI Details\n" + 
//				"--- Time Elapsed: 5.753330513s ---\n" + 
//				"(efa:extreme)extreme@TPVM1:~$";
		
		String qosTrafficCommandResult = "result: efa inventory device execute-cli --ip 30.40.246.5 --command \"show policy-map interface ethernet 0/1\"^M\n" + 
				"Execute CLI[success]^M\n" + 
				"+-------------+-----------------+--------+----------------------------------------+---------+--------+---------------------------------------------------------+^M\n" + 
				"| IP Address  |    Host Name    | Fabric |                Command                 | Status  | Reason |                         Output                          |^M\n" + 
				"+-------------+-----------------+--------+----------------------------------------+---------+--------+---------------------------------------------------------+^M\n" + 
				"| 30.40.246.5 | Border-Leaf-15A | Magok  | show policy-map interface ethernet 0/1 | Success |        | Border-Leaf-15A# show policy-map interface ethernet 0/1 |^M\n" + 
				"|             |                 |        |                                        |         |        |                                                         |^M\n" + 
				"+-------------+-----------------+--------+----------------------------------------+---------+--------+---------------------------------------------------------+^M\n" + 
				"Execute CLI Details^M\n" + 
				"--- Time Elapsed: 5.703392s ---^M\n" + 
				"(efa:extreme)extreme@TPVM1:~$";
		

		String[] lineSplit = qosTrafficCommandResult.split("\n");

		for (String lineStr : lineSplit) {
			
			if (!lineStr.contains("Magok")) {
				continue;
			}
			
//			System.out.println("lineStr: " + lineStr);
			
			String[] vbarSplit = lineStr.split("\\|");

			for (int i =0; i < vbarSplit.length; i++) {
//				System.out.println("vbarStr[" + i + "]: " + vbarSplit[i]);
				
				switch (i) {
				case QOS_TRAFFIC_IPADDRESS: 				// 1
					ipaddress = vbarSplit[i].trim();
					System.out.println("ipaddress: " + ipaddress);
					break;
				case QOS_TRAFFIC_HOST_NAME:					// 2
					hostName = vbarSplit[i].trim();
					System.out.println("hostName: " + hostName);
					break;
				case QOS_TRAFFIC_COMMAND: 				// 3
					command = vbarSplit[i].trim();
					String ethernet = command.replace("show policy-map ", "").trim();
					System.out.println("ethernet: " + ethernet);
					break;
				case QOS_TRAFFIC_STATUS: 				// 4
					status = vbarSplit[i].trim();
					System.out.println("status: " + status);
					break;
				default:
					break;
				}
			}		
		}
	}
}
