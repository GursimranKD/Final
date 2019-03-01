package com.infosys.notificationMS.service;

import com.infosys.notificationMS.dto.AddNotificationDto;
import com.infosys.notificationMS.dto.NotificationsDto;

public interface NotificationService {
	public Boolean addMessage(AddNotificationDto and,String timeStamp);

	public NotificationsDto[] getNotifications(Integer userId) throws Exception;

	void readNotifications(Integer userId);
}
