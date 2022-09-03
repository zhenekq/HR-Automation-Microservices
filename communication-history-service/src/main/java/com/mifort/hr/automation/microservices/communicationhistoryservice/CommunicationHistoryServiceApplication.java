package com.mifort.hr.automation.microservices.communicationhistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommunicationHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationHistoryServiceApplication.class, args);
	}

}
