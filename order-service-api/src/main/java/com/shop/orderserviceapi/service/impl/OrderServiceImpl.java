package com.shop.orderserviceapi.service.impl;

import com.shop.orderserviceapi.dto.OrderDto;
import com.shop.orderserviceapi.entity.Order;
import com.shop.orderserviceapi.repo.OrderRepo;
import com.shop.orderserviceapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {

        String orderId="OR"+generateRandomId();

        Order order=new Order(orderId,orderDto.getCustomerId(),orderDto.getProductIds(),orderDto.getCost());

        orderRepo.save(order);


        return order;
    }

    @Override
    public List<OrderDto> findOrdersByCustomer(String id) {
        List<Order> orders = orderRepo.getOrderByCustomer(id);

        List<OrderDto> orderDtos = orders.stream()
                .map(OrderDto::fromOrder)
                .collect(Collectors.toList());

        return orderDtos;
    }



    private long generateRandomId() {
        Random random = new Random();
        long randomLong = random.nextLong();
        return Math.abs(randomLong % 1_000_000_000L); // Ensures a positive 10-digit number
    }


}
