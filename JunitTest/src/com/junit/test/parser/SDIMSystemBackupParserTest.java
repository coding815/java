package com.junit.test.parser;

import java.util.Arrays;

import org.junit.Test;

public class SDIMSystemBackupParserTest {
	private static final int SDIM_BACKUP_SDI = 1;
	private static final int SDIM_BACKUP_DATABASE = 2;
	private static final int SDIM_BACKUP_RTE_1 = 3;
	private static final int SDIM_BACKUP_RTE_2 = 4;
	
	@Test
	public void sdimBackupParserTest() throws Exception {
			
		String sdimSystemBackupList = " ls -al /var/backups/hds/sdi-system-backup*.tar.gz | awk '{print $9}' | xargs -n 1 basename -s \".tar.gz\"\n" + 
				"sdi-system-backup_2021-11-02_11-17-55\n" + 
				"sdi-system-backup_2021-11-08_12-14-39\n" + 
				"sdi-system-backup_2021-11-10_11-24-09\n" + 
				"sdi-system-backup_2021-11-18_10-17-28\n" + 
				"sdi-system-backup_2021-11-18_10-36-40\n" + 
				"sdi-system-backup_2022-02-08_13-48-22\n" + 
				"sdi-system-backup_2022-02-08_15-53-45\n" + 
				"sdi-system-backup_2022-02-18_18-27-40\n" + 
				"sdi-system-backup_2022-02-21_10-09-56\n" + 
				"sdi-system-backup_2022-03-05_10-05-13\n" + 
				"sdi-system-backup_2022-03-05_10-15-47\n" + 
				"sdi-system-backup_2022-03-08_13-24-04\n" + 
				"sysadmin@sdim-1(active:running) ~$\n" + 
				"";

		String[] lineSplit = sdimSystemBackupList.split("\n");
		Arrays.sort(lineSplit);
		String replaceStr = "";

		for (String lineStr : lineSplit) {
			
			if (!lineStr.contains("sdi-system-backup_")) {
				continue;
			}
			
//			String[] underscoreSplit = blankStr.split("_");
//			underscoreSplitStr = underscoreSplit[1];
//			System.out.println("underscoreSplit[1]: " + underscoreSplit[1]);	
			
			replaceStr = lineStr.replace("sdi-system-backup_", "");
			System.out.println("replaceStr: " + replaceStr);
		}
		
//		String lastSdimSystemBackupDate = underscoreSplitStr;
		String lastSdimSystemBackupDate = replaceStr;
		System.out.println("lastSdimSystemBackupDate: " + lastSdimSystemBackupDate);
	}
	
}
