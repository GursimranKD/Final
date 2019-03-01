package com.infosys.notificationMS.dto;

public class AddNotificationDto {
	private Integer userId;
	private String message;
	private String messageType;
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
	public AddNotificationDto(Integer userId, String message, String messageType) {
		super();
		this.userId = userId;
		this.message = message;
		this.messageType = messageType;
	}
	public AddNotificationDto() {
		
	}
	
	
	
	

}
