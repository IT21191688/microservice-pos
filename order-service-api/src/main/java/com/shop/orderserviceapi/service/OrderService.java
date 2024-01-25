package com.shop.orderserviceapi.service;

import com.shop.orderserviceapi.dto.OrderDto;
import com.shop.orderserviceapi.entity.Order;

public interface OrderService {


    public Order createOrder(OrderDto orderDto);
}
