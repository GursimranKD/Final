package com.infosys.notificationMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import com.infosys.notificationMS.domain.Notifications;
import com.infosys.notificationMS.repository.NotificationRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationMsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c=SpringApplication.run(NotificationMsApplication.class, args);
		NotificationRepository nr=c.getBean(NotificationRepository.class,"notificationRepository");
		nr.save(new Notifications(1,"hello","greeting","today"));
		nr.save(new Notifications(1,"bye","greeting","tomorrow"));
	}
}
