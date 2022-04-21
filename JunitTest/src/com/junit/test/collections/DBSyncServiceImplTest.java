package com.junit.test.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class DBSyncServiceImplTest {

	@Test
	public void test() {
		List<DBSyncBackupHistoryDTO> dbSyncBackupHistoryDTOs = new ArrayList<>();
		DBSyncBackupHistoryDTO backupHistoryDTO = new DBSyncBackupHistoryDTO();
		backupHistoryDTO.setStatus("success");
		backupHistoryDTO.setStartTime("2222-06-02 13:02:34 +0900 KST");
		dbSyncBackupHistoryDTOs.add(backupHistoryDTO);
		
		backupHistoryDTO = new DBSyncBackupHistoryDTO();
		backupHistoryDTO.setStatus("success");
		backupHistoryDTO.setStartTime("2222-06-02 14:02:34 +0900 KST");
		dbSyncBackupHistoryDTOs.add(backupHistoryDTO);
		
		backupHistoryDTO = new DBSyncBackupHistoryDTO();
		backupHistoryDTO.setStatus("in-progress");
		backupHistoryDTO.setStartTime("2222-06-02 18:02:34 +0900 KST");
		dbSyncBackupHistoryDTOs.add(backupHistoryDTO);
		
		backupHistoryDTO = new DBSyncBackupHistoryDTO();
		backupHistoryDTO.setStatus("success");
		backupHistoryDTO.setStartTime("2222-06-02 16:02:34 +0900 KST");
		dbSyncBackupHistoryDTOs.add(backupHistoryDTO);
		
		backupHistoryDTO = new DBSyncBackupHistoryDTO();
		backupHistoryDTO.setStatus("in-progress");
		backupHistoryDTO.setStartTime("2222-06-02 15:02:34 +0900 KST");
		dbSyncBackupHistoryDTOs.add(backupHistoryDTO);
		
		// DBSyncServiceImpl.java - private to public
//		new DBSyncServiceImpl().sort(dbSyncBackupHistoryDTOs);
		
//		Collections.sort(dbSyncBackupHistoryDTOs, new Comparator<DBSyncBackupHistoryDTO>() {
//			@Override
//			public int compare(DBSyncBackupHistoryDTO o1, DBSyncBackupHistoryDTO o2) {
//				return o2.getStartTime().compareTo(o1.getStartTime());
//			}
//		});
//		
//		Collections.sort(dbSyncBackupHistoryDTOs, new Comparator<DBSyncBackupHistoryDTO>() {
//			@Override
//			public int compare(DBSyncBackupHistoryDTO o1, DBSyncBackupHistoryDTO o2) {
//
//				if (o1.getStatus().equals("in-progress")) {
//					return -1;
//				}
//				return 0;
//			}
//		});
		
//		Collections.sort(dbSyncBackupHistoryDTOs, new Comparator<DBSyncBackupHistoryDTO>() {
//			@Override
//			public int compare(DBSyncBackupHistoryDTO o1, DBSyncBackupHistoryDTO o2) {
//
//				if (!o1.getStatus().equals("in-progress")) {
//					o2.getStartTime().compareTo(o1.getStartTime());
//				} else {
//					return -1;
//				}
//				return 1;
//			}
//		});
		
		Collections.sort(dbSyncBackupHistoryDTOs, new Comparator<DBSyncBackupHistoryDTO>() {
			@Override
			public int compare(DBSyncBackupHistoryDTO o1, DBSyncBackupHistoryDTO o2) {
				if (!(o1.getStatus().equals("in-progress") && 
						o2.getStatus().equals("in-progress"))) {
					if (o1.getStatus().equals("in-progress")) {
						return -1;
					}
					if (o2.getStatus().equals("in-progress")) {
						return 1;
					}	
				}
				return o2.getStartTime().compareTo(o1.getStartTime());
			}
		});
		
		dbSyncBackupHistoryDTOs.stream().forEach(System.out::println);
	}

}

