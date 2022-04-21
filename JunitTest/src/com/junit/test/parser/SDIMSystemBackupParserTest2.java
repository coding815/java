package com.junit.test.parser;

import java.util.Arrays;

import org.junit.Test;

public class SDIMSystemBackupParserTest2 {
	private static final int SDIM_BACKUP_SDI = 1;
	private static final int SDIM_BACKUP_DATABASE = 2;
	private static final int SDIM_BACKUP_RTE_1 = 3;
	private static final int SDIM_BACKUP_RTE_2 = 4;
	
	@Test
	public void sdimBackupParserTest() throws Exception {
			
		String sdimSystemBackupList = " cd /var/backups/hds\n" + 
				"operator@sdim-1(active:running) /var/backups/hds$ ls\n" + 
				"lost+found                                    sdi-system-backup_2021-11-18_10-36-40.tar.gz  sdi-system-backup_2022-03-05_10-15-47.tar.gz\n" + 
				"pre-restore                                   sdi-system-backup_2022-02-08_13-48-22.tar.gz  tar_process2021-11-10_11-27-24.log\n" + 
				"sdi-system-backup_2021-11-02_11-17-55.tar.gz  sdi-system-backup_2022-02-08_15-53-45.tar.gz  tar_process2021-11-10_11-45-43.log\n" + 
				"sdi-system-backup_2021-11-08_12-14-39.tar.gz  sdi-system-backup_2022-02-18_18-27-40.tar.gz  tar_process2021-11-18_10-15-01.log\n" + 
				"sdi-system-backup_2021-11-10_11-24-09.tar.gz  sdi-system-backup_2022-02-21_10-09-56.tar.gz  tar_process2022-02-08_13-09-36.log\n" + 
				"sdi-system-backup_2021-11-18_10-17-28.tar.gz  sdi-system-backup_2022-03-05_10-05-13.tar.gz\n" + 
				"operator@sdim-1(active:running) /var/backups/hds$";

		String[] blankSplit = sdimSystemBackupList.split("\\s+");
		Arrays.sort(blankSplit);
		String subStr = "";
		String underscoreSplitStr = "";
		String underscoreSplitStr2 = "";

		for (String blankStr : blankSplit) {
			
			if (!blankStr.contains("sdi-system-backup")) {
				continue;
			}
			
//			String[] underscoreSplit = blankStr.split("_");
//			underscoreSplitStr = underscoreSplit[1];
//			System.out.println("underscoreSplit[1]: " + underscoreSplit[1]);	
			
			subStr = blankStr.substring(18, 37);
			System.out.println("subStr: " + subStr);
		}
		
//		String lastSdimSystemBackupDate = underscoreSplitStr;
		String lastSdimSystemBackupDate = subStr;
		System.out.println("lastSdimSystemBackupDate: " + lastSdimSystemBackupDate);
	}
	
}
