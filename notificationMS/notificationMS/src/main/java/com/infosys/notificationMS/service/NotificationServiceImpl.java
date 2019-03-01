package com.infosys.notificationMS.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.notificationMS.domain.Notifications;
import com.infosys.notificationMS.dto.AddNotificationDto;
import com.infosys.notificationMS.dto.NotificationsDto;
import com.infosys.notificationMS.exception.ServiceException;
import com.infosys.notificationMS.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	NotificationRepository notificationRepository;
	
	@Override
	public Boolean addMessage(AddNotificationDto addNotificationDto,String timeStamp) {
		notificationRepository.save(new Notifications(addNotificationDto.getUserId(),addNotificationDto.getMessage(),addNotificationDto.getMessageType(),timeStamp));
		return true;	
	}

	@Override
	public NotificationsDto[] getNotifications(Integer userId) throws Exception{
		
		Notifications[] note=notificationRepository.findByUserId(userId);
		if(note.length!=0) {
			List<Notifications> x=Arrays.asList(note);
			
			List<Notifications> result = new ArrayList<>();
	        
	        for (Notifications person: x) {
	            if (!person.getRead()) {
	                result.add(person);
	            }
	        }
	        
        	Notifications[] finale=result.toArray(new Notifications[result.size()]);
        	return NotificationsDto.CreateDtoArray(finale);
	        
	        
			
		}
		else {
			
			throw new ServiceException("There is no user");
		}
		
		
	}
	@Override
	public void readNotifications(Integer userId) {
		notificationRepository.readNotifications(userId,true);
		
	}

}
