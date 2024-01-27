package com.shop.customerserviceapi.Service.impl;

import com.shop.customerserviceapi.Service.CustomerService;
import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.dto.OrderDto;
import com.shop.customerserviceapi.dto.responceDtos.ResponceOrderDto;
import com.shop.customerserviceapi.entity.Customer;
import com.shop.customerserviceapi.exeptions.CustomException;
import com.shop.customerserviceapi.feign.OrderFaignClient;
import com.shop.customerserviceapi.repo.CustomerRepo;
import com.shop.customerserviceapi.utill.responce.CustomCustomerResponce;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Random;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    @Autowired
    private WebClient webClient;

    @Autowired
    private OrderFaignClient orderFaignClient;



    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, WebClient webClient, OrderFaignClient orderFaignClient) {
        this.customerRepo = customerRepo;
        this.webClient = webClient;
        this.orderFaignClient = orderFaignClient;
    }



    public Customer createCustomer(CustomerDto dtos) {

        String customerId="CU"+generateRandomId();

        Customer customer = new Customer(customerId, dtos.getName(), dtos.getAddress(), dtos.getSalary());
        customerRepo.save(customer);
        return customer;
    }


    public CustomCustomerResponce getCustomerById(String customerId){

        Customer customer=customerRepo.getCustomerById(customerId);
        if(customer==null){
            throw new CustomException("Customer with ID " + customerId + " not found");
        }
        List<OrderDto> orders=orderFaignClient.findOrdersByCustomerId(customer.getId());

        CustomCustomerResponce responce=new CustomCustomerResponce();

        System.out.println(orders.toString());
        responce.setCustomer(customer);
        responce.setOrders(orders);

        return responce;

    }


//    private List<OrderDto> findOrders(String id) {
//        Flux<OrderDto> orderFlux = webClient
//                .get()
//                .uri("/getCustomerOrders/" + id)
//                .retrieve()
//                .bodyToFlux(OrderDto.class);
//
//        return orderFlux.collectList().block();
//    }




    private long generateRandomId() {
        Random random = new Random();
        long randomLong = random.nextLong();
        return Math.abs(randomLong % 1_000_000_000L); // Ensures a positive 10-digit number
    }
}
