package com.shop.orderserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApiApplication.class, args);
	}

}
