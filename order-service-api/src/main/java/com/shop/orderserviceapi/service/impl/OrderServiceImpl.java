package com.shop.orderserviceapi.service.impl;

import com.shop.orderserviceapi.dto.OrderDto;
import com.shop.orderserviceapi.entity.Order;
import com.shop.orderserviceapi.repo.OrderRepo;
import com.shop.orderserviceapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {

        Order order=new Order(generateRandomId(),orderDto.getCustomerId(),orderDto.getProductIds(),orderDto.getCost());



        orderRepo.save(order);


        return order;
    }


    private long generateRandomId() {
        Random random = new Random();
        long randomLong = random.nextLong();
        return Math.abs(randomLong % 1_000_000_000L); // Ensures a positive 10-digit number
    }
}
