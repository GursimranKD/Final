package com.infosys.notificationMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.notificationMS.dto.AddNotificationDto;
import com.infosys.notificationMS.dto.NotificationsDto;
import com.infosys.notificationMS.service.NotificationServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class NotificationController {
	@Autowired
	NotificationServiceImpl nsi;
	
	@GetMapping(value="/{userId}/notifications")
	public ResponseEntity<NotificationsDto[]> getNotifications(@PathVariable("userId") Integer userId ) throws Exception{
			NotificationsDto[] x=nsi.getNotifications(userId);
			System.out.println();
		return new ResponseEntity<NotificationsDto[]>(x,HttpStatus.OK);
	}
	
	
	@PostMapping(value="/addNotification/{timeStamp}")
	public ResponseEntity<Boolean> addNotification(@RequestBody AddNotificationDto and,@PathVariable("timeStamp") String timeStamp) {
		Boolean result=nsi.addMessage(and, timeStamp);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}/readNotifications")
	public void readNotifications(@PathVariable("userId") Integer userId ){
		nsi.readNotifications(userId);	
	}

}
