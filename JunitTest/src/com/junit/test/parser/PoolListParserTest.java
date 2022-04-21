package com.junit.test.parser;

import org.junit.Test;

public class PoolListParserTest {
	
	@Test
	public void poolListParser() throws Exception {
		String fabricInfoSwitch = " NAME          SIZE    ALLOC    FREE   AVAIL  DEDUP  EXPANDSZ  FRAG  HEALTH\n" + 
				" CNIS_HA_POOL  16.89T  11.06T   5.83T  35%    1.00x  -         59%   ONLINE\n" + 
				" rpool         1.41T   113.85G  1.30T  92%    1.00x  -         0%    ONLINE\n" + 
				"CLI@NexentaStor-2>";
		
		// ### Kei: line-break remove
		fabricInfoSwitch = fabricInfoSwitch.replaceAll("\r", "");
		
		System.out.println("==================================================================");
		
		String pool_name 		= "";
		String pool_size 		= "";
		String pool_alloc 		= "";
		String pool_free 		= "";
		String pool_avail 		= "";
		String pool_dedup 		= "";
		String pool_expandsz 	= "";
		String pool_frag 		= "";
		String pool_health 		= "";
		double total			= 0.0;
		double used				= 0.0;
		double pfree			= 0.0;
		double avail			= 0.0;
		double used_rate		= 0.0;
		
		// ### Kei: separate Fabric Switch from Fabric Info Switch
		String[] lineSplit = fabricInfoSwitch.split("\n");
		
		for (String lineStr : lineSplit) {
			
			if (!lineStr.contains("CNIS_HA_POOL")) {
				continue;
			}
			
			System.out.println("lineStr :" + lineStr);
			System.out.println("");
			
			String[] blankSplit = lineStr.split("\\s+");
//			String counts = blankSplit[0];
			for (int i =0; i < blankSplit.length; i++) {
				System.out.println("blankSplit[" + i + "]: " + blankSplit[i]);
				
				String convertString = blankSplit[i];
				Double convertDouble = 0.0;
				int convertInt = 0;
				
				if (convertString.contains("T")) {
					convertString = convertString.replace("T", "").trim();
					convertDouble = Double.parseDouble(convertString) * 1024 * 1024;
				} else if (convertString.contains("G")) {
					convertString = convertString.replace("G", "").trim();
					convertDouble = Double.parseDouble(convertString) * 1024;
				} else if (convertString.contains("M")) {
					convertString = convertString.replace("M", "").trim();
					convertDouble = Double.parseDouble(convertString);
				} else if (convertString.contains("K")) {
					convertString = convertString.replace("K", "").trim();
					convertDouble = Double.parseDouble(convertString) / 1024;
				} else if (convertString.contains("%")) {
					convertString = convertString.replace("%", "").trim();
					convertInt =  Integer.parseInt(convertString);
				}

				switch(i) {
					case 2:
						total = convertDouble;
						System.out.println("total: " + total);
						break;
					case 3:
						used = convertDouble;
						System.out.println("used: " + used);
						break;
					case 4:
						pfree = convertDouble;
						System.out.println("pfree: " + pfree);
						break;
					case 5:
						avail = convertInt;
						System.out.println("avail: " + avail);
				}
			}
			
			used_rate = 100 - avail;
			System.out.println("used_rate: " + used_rate);
			
//			int index = 0;
//			for (String blankStr : blankSplit) {
//			
//				System.out.println("blankStr[" + index + "]: " + blankStr);
//				index++;
//			}
		}
	}
}

