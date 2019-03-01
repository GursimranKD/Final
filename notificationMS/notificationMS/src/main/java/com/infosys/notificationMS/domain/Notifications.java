package com.infosys.notificationMS.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Notifications {
	@GeneratedValue
	@Id
	private Integer notificationID;
	private Integer userId;
	private String message;
	private String messageType;
	private String timeStamp;
	
	private Boolean read=false;
	
	
	
	
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public Integer getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(Integer notificationID) {
		this.notificationID = notificationID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Notifications(Integer userId, String message, String messageType, String timeStamp) {
		super();
		
		this.userId = userId;
		this.message = message;
		this.messageType = messageType;
		this.timeStamp = timeStamp;
	}
	public Notifications() {
		
	}
	
	
	
	

}
