package com.shop.customerserviceapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${order.service.url}")
    private String orderServiceUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(orderServiceUrl).build();
    }
}

