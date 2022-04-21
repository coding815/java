package com.junit.test.collections;

public class DBSyncBackupHistoryDTO {

	String uuid;
	Long snapShot;
	String reason;
	String status;
	String startTime;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getSnapShot() {
		return snapShot;
	}
	public void setSnapShot(Long snapShot) {
		this.snapShot = snapShot;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
	
}
