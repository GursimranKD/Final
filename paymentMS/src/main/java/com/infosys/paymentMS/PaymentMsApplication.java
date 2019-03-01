package com.infosys.paymentMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;


import com.infosys.paymentMS.domain.CardInfo;
import com.infosys.paymentMS.repository.CardInfoRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c=SpringApplication.run(PaymentMsApplication.class, args);
		
		CardInfoRepository cr=(CardInfoRepository)c.getBean("cardInfoRepository");
		cr.save(new CardInfo("1234567890123456","tejeswar",3,1996,1001));
		cr.save(new CardInfo("1111222233334444","gauthum",3,1996,1002));
		cr.save(new CardInfo("2222333344445555","arjun",3,1996,1002));
	}
}
