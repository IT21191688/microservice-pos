package com.shop.customerserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApiApplication.class, args);
	}

}
