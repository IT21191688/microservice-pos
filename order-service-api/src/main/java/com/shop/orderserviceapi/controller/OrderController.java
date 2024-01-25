package com.shop.orderserviceapi.controller;

import com.shop.orderserviceapi.dto.OrderDto;
import com.shop.orderserviceapi.entity.Order;
import com.shop.orderserviceapi.service.OrderService;
import com.shop.orderserviceapi.utill.responce.CustomResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }




    @PostMapping(path = "/create")
    public ResponseEntity<CustomResponce> createOrder(@RequestBody OrderDto orderDto){

        Order order=orderService.createOrder(orderDto);


        return new ResponseEntity<>(
                new CustomResponce(order,201,"Success",true),
                HttpStatus.OK
        );


    }



}
