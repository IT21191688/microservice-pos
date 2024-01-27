package com.shop.orderserviceapi.service;

import com.shop.orderserviceapi.dto.OrderDto;
import com.shop.orderserviceapi.entity.Order;

import java.util.List;

public interface OrderService {


    public Order createOrder(OrderDto orderDto);

    public List<OrderDto> findOrdersByCustomer(String id);
}
