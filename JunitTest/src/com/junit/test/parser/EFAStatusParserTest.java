package com.junit.test.parser;

import org.junit.Test;

public class EFAStatusParserTest {
	private static final int EFA_STATUS_NODE_NAME = 1;
	private static final int EFA_STATUS_ROLE = 2;
	private static final int EFA_STATUS_STATUS= 3;
	private static final int EFA_STATUS_IPADDRESS = 4;
	
	@Test
	public void efaStatusParserTest() throws Exception {
		
		String nodeName 		= "";
		String role	 			= "";
		String status 			= "";
		String ipaddress  		= "";
			
		String efaCommandResult = " efa status\n" + 
				"+-----------+---------+--------+---------------+\n" + 
				"| Node Name | Role    | Status | IP            |\n" + 
				"+-----------+---------+--------+---------------+\n" + 
				"| tpvm1     | active  | up     | 60.30.181.99  |\n" + 
				"+-----------+---------+--------+---------------+\n" + 
				"| tpvm2     | standby | up     | 60.30.181.100 |\n" + 
				"+-----------+---------+--------+---------------+\n" + 
				"--- Time Elapsed: 14.327964667s ---\n" + 
				"(efa:extreme)extreme@tpvm1:~$ ";

		String[] lineSplit = efaCommandResult.split("\n");

		for (String lineStr : lineSplit) {
			
			if (lineStr.contains("efa") || lineStr.contains(" Node Name") || lineStr.contains("---")) {
				continue;
			}
			
			System.out.println("lineStr :" + lineStr);
			System.out.println("");
			
			String[] vbarSplit = lineStr.split("\\|");

			for (int i =0; i < vbarSplit.length; i++) {
//				System.out.println("vbarStr[" + i + "]: " + vbarSplit[i]);
				
				switch (i) {
				case EFA_STATUS_NODE_NAME: 				// 1
					nodeName = vbarSplit[i].trim();
					System.out.println("nodeName: " + nodeName);
					break;
				case EFA_STATUS_ROLE:					// 2
					role = vbarSplit[i].trim();
					System.out.println("role: " + role);
					break;
				case EFA_STATUS_STATUS: 				// 3
					status = vbarSplit[i].trim();
					System.out.println("status: " + status);
					break;
				case EFA_STATUS_IPADDRESS: 				// 4
					ipaddress = vbarSplit[i].trim();
					System.out.println("ipaddress: " + ipaddress);
					break;
				default:
					break;
				}
			}
		}
	}
}
