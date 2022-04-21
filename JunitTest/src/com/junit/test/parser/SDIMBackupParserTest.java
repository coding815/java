package com.junit.test.parser;

import org.junit.Test;

public class SDIMBackupParserTest {
	
	@Test
	public void sdimBackupParserTest() throws Exception {
		
		String sdi 			= "";
		String database	 	= "";
		String rte_1		= "";
		String rte_2  		= "";
		
//		String sdimBackupCommandResult = "[ Started: Backuptool Lock Check ]\n" + 
//				"        Success: Locking Backuptool with pid 19410, continuing\n" + 
//				"[ Finished: Backuptool Lock Check ]\n" + 
//				"[ Started: Pre backup tasks on SDIm ]\n" + 
//				"        [ Started: Check free disk space for backup ]\n" + 
//				"                Partition: /var/backups/hds\n" + 
//				"                Estimated backup size ~ 183.47 MB\n" + 
//				"                Free space before backup, disk: 66% (~ 28.13 GB)\n" + 
//				"                Estimated free space after backup: 66% (~ 27.95 GB)\n" + 
//				"                Min percent which must be free before backup: 10.0%\n" + 
//				"                Success: Free diskspace check passed, continuing\n" + 
//				"        [ Finished: Check free disk space for backup ]\n" + 
//				"        [ Started: Check HA role of localhost ]\n" + 
//				"                Success: Localhost HA role verification, continuing\n" + 
//				"        [ Finished: Check HA role of localhost ]\n" + 
//				"        [ Started: Check if HA status is running ]\n" + 
//				"                [ Started: Check HA status ]\n" + 
//				"                        Success: HA status check, continuing\n" + 
//				"                [ Finished: Check HA status ]\n" + 
//				"        [ Finished: Check if HA status is running ]\n" + 
//				"        [ Started: Check software level of SDI packages ]\n" + 
//				"                Success: Software inventory check, continuing\n" + 
//				"        [ Finished: Check software level of SDI packages ]\n" + 
//				"        [ Started: Check active alarms ]\n" + 
//				"                Success: No critical alarm, continuing\n" + 
//				"        [ Finished: Check active alarms ]\n" + 
//				"        [ Started: Check state of SDIM REST API tasks ]\n" + 
//				"                Success: No running task, continuing\n" + 
//				"        [ Finished: Check state of SDIM REST API tasks ]\n" + 
//				"[ Finished: Pre backup tasks on SDIm ]\n" + 
//				"[ Started: Backup of RTEs ]\n" + 
//				"        [ Started: Main backup tasks on RTEs ]\n" + 
//				"        [ Finished: Main backup tasks on RTEs ]\n" + 
//				"        [ Started: Post backup tasks on RTEs ]\n" + 
//				"                Success: Checksum validation, continuing\n" + 
//				"                Success: Checksum validation, continuing\n" + 
//				"        [ Finished: Post backup tasks on RTEs ]\n" + 
//				"        Success: Backup of RTEs, continuing\n" + 
//				"[ Finished: Backup of RTEs ]\n" + 
//				"[ Started: Main backup tasks on SDIm ]\n" + 
//				"        [ Started: Backup postgres DB ]\n" + 
//				"                Success: Postgres DB backup file created, continuing\n" + 
//				"        [ Finished: Backup postgres DB ]\n" + 
//				"        [ Started: Executing Backup Command ]\n" + 
//				"                Executing: (Please be patient)\n" + 
//				"        [ Finished: Executing Backup Command ]\n" + 
//				"        [ Started: Backup Validation ]\n" + 
//				"                [ Started: Log Validation of included/excluded paths ]\n" + 
//				"                        Success: Log Validation of included/excluded paths, continuing\n" + 
//				"                [ Finished: Log Validation of included/excluded paths ]\n" + 
//				"                Success: Gzip validation, continuing\n" + 
//				"        [ Finished: Backup Validation ]\n" + 
//				"[ Finished: Main backup tasks on SDIm ]\n" + 
//				"[ Started: Evaluation of data consistency ]\n" + 
//				"        Error: PsqlConsistencyChecker failed.\n" + 
//				"        Attempt 1/3 failed on one of consistency check, Data consistency check failed, changes are observed in following tables: dalarmentrydata.\n" + 
//				"        [ Started: Main backup tasks on SDIm ]\n" + 
//				"        [ Started: Backup postgres DB ]\n" + 
//				"                Success: Postgres DB backup file created, continuing\n" + 
//				"        [ Finished: Backup postgres DB ]\n" + 
//				"        [ Started: Executing Backup Command ]\n" + 
//				"                Executing: (Please be patient)\n" + 
//				"        [ Finished: Executing Backup Command ]\n" + 
//				"        [ Started: Backup Validation ]\n" + 
//				"                [ Started: Log Validation of included/excluded paths ]\n" + 
//				"                        Success: Log Validation of included/excluded paths, continuing\n" + 
//				"                [ Finished: Log Validation of included/excluded paths ]\n" + 
//				"                Success: Gzip validation, continuing\n" + 
//				"        [ Finished: Backup Validation ]\n" + 
//				"[ Finished: Main backup tasks on SDIm ]\n" + 
//				"[ Started: Evaluation of data consistency ]\n" + 
//				"        Error: PsqlConsistencyChecker failed.\n" + 
//				"        Attempt 2/3 failed on one of consistency check, Data consistency check failed, changes are observed in following tables: dalarmentrydata.\n" + 
//				"        [ Started: Main backup tasks on SDIm ]\n" + 
//				"        [ Started: Backup postgres DB ]\n" + 
//				"                Success: Postgres DB backup file created, continuing\n" + 
//				"        [ Finished: Backup postgres DB ]\n" + 
//				"        [ Started: Executing Backup Command ]\n" + 
//				"                Executing: (Please be patient)\n" + 
//				"        [ Finished: Executing Backup Command ]\n" + 
//				"        [ Started: Backup Validation ]\n" + 
//				"                [ Started: Log Validation of included/excluded paths ]\n" + 
//				"                        Success: Log Validation of included/excluded paths, continuing\n" + 
//				"                [ Finished: Log Validation of included/excluded paths ]\n" + 
//				"                Success: Gzip validation, continuing\n" + 
//				"        [ Finished: Backup Validation ]\n" + 
//				"[ Finished: Main backup tasks on SDIm ]\n" + 
//				"[ Started: Evaluation of data consistency ]\n" + 
//				"        Error: PsqlConsistencyChecker failed.\n" + 
//				"        Attempt 3/3 failed on one of consistency check, Data consistency check failed, changes are observed in following tables: dalarmentrydata.\n" + 
//				"        Error: The backup collection is rejected, the changes in configuration on SDI Manager or on data fabric have been observed. Please try it once the configuration is finished.\n" + 
//				"        [ Started: Final status report ]\n" + 
//				"                SDI: not done\n" + 
//				"                database: backup successful\n" + 
//				"                rte-1: backup successful\n" + 
//				"                rte-2: backup successful\n" + 
//				"                fabric: not done\n" + 
//				"                [ Started: Show timing ]\n" + 
//				"                        DO PRE BACKUP SDIM : 25.819\n" + 
//				"                        START BACKUP RTE : 1.655\n" + 
//				"                        POST BACKUP RTE : 0.985\n" + 
//				"                        DO START BACKUP SDIM : 7.692\n" + 
//				"                [ Finished: Show timing ]\n" + 
//				"        [ Finished: Final status report ]\n" + 
//				"An Error \"Data consistency check failed, changes are observed in following tables: dalarmentrydata.\" detected, aborting\n" + 
//				"sysadmin@sdim-1(active:running) ~$\n" + 
//				"";
			
		String sdimBackupCommandResult = " sditool backup create --online --no-fabric --no-bootimg\n" + 
				"[ Started: Backuptool Lock Check ]\n" + 
				"        Success: Locking Backuptool with pid 31990, continuing\n" + 
				"[ Finished: Backuptool Lock Check ]\n" + 
				"[ Started: Pre backup tasks on SDIm ]\n" + 
				"        [ Started: Check free disk space for backup ]\n" + 
				"                Partition: /var/backups/hds\n" + 
				"                Estimated backup size ~ 183.46 MB\n" + 
				"                Free space before backup, disk: 67% (~ 28.3 GB)\n" + 
				"                Estimated free space after backup: 66% (~ 28.13 GB)\n" + 
				"                Min percent which must be free before backup: 10.0%\n" + 
				"                Success: Free diskspace check passed, continuing\n" + 
				"        [ Finished: Check free disk space for backup ]\n" + 
				"        [ Started: Check HA role of localhost ]\n" + 
				"                Success: Localhost HA role verification, continuing\n" + 
				"        [ Finished: Check HA role of localhost ]\n" + 
				"        [ Started: Check if HA status is running ]\n" + 
				"                [ Started: Check HA status ]\n" + 
				"                        Success: HA status check, continuing\n" + 
				"                [ Finished: Check HA status ]\n" + 
				"        [ Finished: Check if HA status is running ]\n" + 
				"        [ Started: Check software level of SDI packages ]\n" + 
				"                Success: Software inventory check, continuing\n" + 
				"        [ Finished: Check software level of SDI packages ]\n" + 
				"        [ Started: Check active alarms ]\n" + 
				"                Success: No critical alarm, continuing\n" + 
				"        [ Finished: Check active alarms ]\n" + 
				"        [ Started: Check state of SDIM REST API tasks ]\n" + 
				"                Success: No running task, continuing\n" + 
				"        [ Finished: Check state of SDIM REST API tasks ]\n" + 
				"[ Finished: Pre backup tasks on SDIm ]\n" + 
				"[ Started: Backup of RTEs ]\n" + 
				"        [ Started: Main backup tasks on RTEs ]\n" + 
				"        [ Finished: Main backup tasks on RTEs ]\n" + 
				"        [ Started: Post backup tasks on RTEs ]\n" + 
				"                Success: Checksum validation, continuing\n" + 
				"                Success: Checksum validation, continuing\n" + 
				"        [ Finished: Post backup tasks on RTEs ]\n" + 
				"        Success: Backup of RTEs, continuing\n" + 
				"[ Finished: Backup of RTEs ]\n" + 
				"[ Started: Main backup tasks on SDIm ]\n" + 
				"        [ Started: Backup postgres DB ]\n" + 
				"                Success: Postgres DB backup file created, continuing\n" + 
				"        [ Finished: Backup postgres DB ]\n" + 
				"        [ Started: Executing Backup Command ]\n" + 
				"                Executing: (Please be patient)\n" + 
				"        [ Finished: Executing Backup Command ]\n" + 
				"        [ Started: Backup Validation ]\n" + 
				"                [ Started: Log Validation of included/excluded paths ]\n" + 
				"                        Success: Log Validation of included/excluded paths, continuing\n" + 
				"                [ Finished: Log Validation of included/excluded paths ]\n" + 
				"                Success: Gzip validation, continuing\n" + 
				"        [ Finished: Backup Validation ]\n" + 
				"[ Finished: Main backup tasks on SDIm ]\n" + 
				"[ Started: Evaluation of data consistency ]\n" + 
				"        Success: PsqlConsistencyChecker, continuing\n" + 
				"        Success: FileSystemConsistencyChecker, continuing\n" + 
				"[ Finished: Evaluation of data consistency ]\n" + 
				"[ Started: Post backup tasks on SDIm ]\n" + 
				"        [ Started: Starting services ]\n" + 
				"                docker service is in state active\n" + 
				"                [ Started: Wait for SDI processes ]\n" + 
				"                        Current state of SDI processes running/total: 70/70\n" + 
				"                        All SDI processes are running\n" + 
				"                [ Finished: Wait for SDI processes ]\n" + 
				"        [ Finished: Starting services ]\n" + 
				"[ Finished: Post backup tasks on SDIm ]\n" + 
				"[ Started: Final status report ]\n" + 
				"        SDI: backup successful\n" + 
				"        database: backup successful\n" + 
				"        rte-1: backup successful\n" + 
				"        rte-2: backup successful\n" + 
				"        fabric: not done\n" + 
				"        [ Started: Show timing ]\n" + 
				"                DO PRE BACKUP SDIM : 25.149\n" + 
				"                START BACKUP RTE : 1.679\n" + 
				"                POST BACKUP RTE : 0.950\n" + 
				"                DO START BACKUP SDIM : 6.654\n" + 
				"                DO POST BACKUP SDIM : 1.522\n" + 
				"        [ Finished: Show timing ]\n" + 
				"        Backup file location: /var/backups/hds/sdi-system-backup_2022-03-05_10-05-13.tar.gz\n" + 
				"[ Finished: Final status report ]\n" + 
				"sysadmin@sdim-1(active:running) ~$";

		String[] lineSplit = sdimBackupCommandResult.split("\n");

		for (String lineStr : lineSplit) {
			
			if (lineStr.contains("SDI:")) {
				sdi = lineStr.replace("SDI:", "").trim();
				System.out.println("sdi: " + sdi);
			}
			
			if (lineStr.contains("database:")) {
				database = lineStr.replace("database:", "").trim();
				System.out.println("database: " + database);
			}
			
			if (lineStr.contains("rte-1:")) {
				rte_1 = lineStr.replace("rte-1:", "").trim();
				System.out.println("rte-1: " + rte_1);
			}
			
			if (lineStr.contains("rte-2:")) {
				rte_2 = lineStr.replace("rte-2:", "").trim();
				System.out.println("rte-2: " + rte_2);
			}
			
		}
	}
}
