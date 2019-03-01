package com.infosys.eKart;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Repository.UserRepository;





@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages="com.infosys")
public class EKartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c=SpringApplication.run(EKartApplication.class, args);
		UserRepository ur = c.getBean("userRepository", UserRepository.class);
		Address add = new Address(101, "anuva", "Banglore", "karnataka", 8907654L, "2345678901");
		ArrayList<Address> list1= new ArrayList<Address>();
		list1.add(add);
		User user1= new User(1, "anuva", "anuva@infy.com", "Hello@123", list1,1);
		
		ur.saveAndFlush(user1);
		
	}
}


