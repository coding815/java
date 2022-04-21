package com.junit.test.parser;

import org.junit.Test;

public class EnclosureStatusParserTest {
	
	@Test
	public void enclosureStatusTest() throws Exception {
		
		String pool 			= "";
		String enclosure	 	= "";
		String model 			= "";
		String capacity 		= "";
		String status 			= "";
		String error_reason 	= "";
		
		String tempEnclosureStatusCommand0 = " enclosure   500056b36e5193ff\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DP BP14G+EXP with 16 bays (2 used)\n" + 
				" capacity    3.20TB on 2 disk(s) (2 SSD)\n" + 
				" pools       rpool\n" + 
				" system      this enclosure hosts the system pool: rpool\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				" enclosure   520474729a90ba00\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DELL MD1420 with 24 bays (12 used)\n" + 
				" capacity    19.20TB on 12 disk(s) (12 SSD)\n" + 
				" pools       no active pools\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				" enclosure   520474729a8e2100\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DELL MD1420 with 24 bays (12 used)\n" + 
				" capacity    19.20TB on 12 disk(s) (12 SSD)\n" + 
				" pools       no active pools\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				"CLI@NexentaStor-1>";
			
		String tempEnclosureStatusCommand1 = " enclosure   500056b3a784f4ff\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DP BP14G+EXP with 16 bays (2 used)\n" + 
				" capacity    3.20TB on 2 disk(s) (2 SSD)\n" + 
				" pools       rpool\n" + 
				" system      this enclosure hosts the system pool: rpool\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				" enclosure   520474729a90ba00\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DELL MD1420 with 24 bays (12 used)\n" + 
				" capacity    19.20TB on 12 disk(s) (12 SSD)\n" + 
				" pools       CNIS_HA_POOL\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				" enclosure   520474729a8e2100\n" + 
				" management  this enclosure is managed via the default interface\n" + 
				" model       DELL MD1420 with 24 bays (12 used)\n" + 
				" capacity    19.20TB on 12 disk(s) (12 SSD)\n" + 
				" pools       CNIS_HA_POOL\n" + 
				" status      ONLINE; no known issues\n" + 
				"\n" + 
				"CLI@NexentaStor-2>";

		String[] paragraphSplit = tempEnclosureStatusCommand1.split("\n\n");
		
		for (String paragraphStr : paragraphSplit) {
					
			if (!paragraphStr.contains("CNIS_HA_POOL")) {
				continue;
			}
			
			System.out.println("paragraphStr :");
			System.out.println(paragraphStr);
			
			String[] lineSplit = paragraphStr.split("\n");

			for (String lineStr : lineSplit) {
				
				if (lineStr.contains("management") || lineStr.contains("rpool")) {
					continue;
				}
				
				System.out.println("lineStr :" + lineStr);
				System.out.println("");
				
				if (lineStr.contains("pools")) {
					pool = lineStr.replace("pools", "").trim();
					System.out.println("pools: " + pool);
				}
				
				if (lineStr.contains("enclosure")) {
					enclosure = lineStr.replace("enclosure", "").trim();
					System.out.println("enclosure: " + enclosure);
				}
				
				if (lineStr.contains("model")) {
					model = lineStr.replace("model", "").trim();
					System.out.println("model: " + model);
				}
				
				if (lineStr.contains("capacity")) {
					capacity = lineStr.replace("capacity", "").trim();
					System.out.println("capacity: " + capacity);
				}
				
				if (lineStr.contains("status")) {
					String statusTemp = lineStr.replace("status", "").trim();
					System.out.println("statusTemp: " + statusTemp);
					
					String[] semicolonSplit = statusTemp.split(";");
					status = semicolonSplit[0].trim();
					System.out.println("status: " + status);
					error_reason = semicolonSplit[1].trim();
					System.out.println("error_reason: " + error_reason);
				}	
			}
		}
	}
}

