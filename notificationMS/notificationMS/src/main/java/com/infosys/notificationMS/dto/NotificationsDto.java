package com.infosys.notificationMS.dto;

import com.infosys.notificationMS.domain.Notifications;

public class NotificationsDto {
	
	private String message;
	private String messageType;
	private String timeStamp;
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
	public NotificationsDto(String message, String messageType, String timeStamp) {
		super();
		this.message = message;
		this.messageType = messageType;
		this.timeStamp = timeStamp;
	}
	public NotificationsDto() {
		
	}
	public static NotificationsDto[] CreateDtoArray(Notifications[] y) {
		NotificationsDto[] x=new NotificationsDto[y.length];
		for(int i=0;i<y.length;i++) {
			x[i]=new NotificationsDto(y[i].getMessage(),y[i].getMessageType(),y[i].getTimeStamp());
		}
		return x;
		
	}
	
	

}
