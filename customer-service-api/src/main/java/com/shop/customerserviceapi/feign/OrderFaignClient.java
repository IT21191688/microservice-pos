package com.shop.customerserviceapi.feign;


import com.shop.customerserviceapi.dto.OrderDto;
import com.shop.customerserviceapi.dto.responceDtos.ResponceOrderDto;
import com.shop.customerserviceapi.utill.responce.CustomCustomerResponce;
import com.shop.customerserviceapi.utill.responce.CustomResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "${order.service.url}" ,path = "/api/v1/orders",value = "order-feign-client")
public interface OrderFaignClient {


    @GetMapping(path = "/getCustomerOrders/{id}")
    public List<OrderDto> findOrdersByCustomerId(@PathVariable String id);


}
