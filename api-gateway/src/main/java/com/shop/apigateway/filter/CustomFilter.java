package com.shop.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

    //pre filter
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //security
        ServerHttpRequest serverHttpRequest=exchange.getRequest();

        System.out.println("Auth :"+serverHttpRequest.getHeaders().getFirst("Authorization"));


        return chain.filter(exchange);
    }
}
