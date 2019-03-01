package com.infosys.notificationMS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infosys.notificationMS.domain.Notifications;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications,Integer>{
	public Notifications[] findByUserId(Integer userId);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update Notifications a set a.read=:flag where a.userId=:id")
	public void readNotifications(@Param("id") Integer userId,@Param("flag") Boolean flag);

}
