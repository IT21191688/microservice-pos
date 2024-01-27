package com.shop.customerserviceapi.controller;


import com.shop.customerserviceapi.Service.CustomerService;
import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.dto.OrderDto;
import com.shop.customerserviceapi.entity.Customer;
import com.shop.customerserviceapi.utill.responce.CustomCustomerResponce;
import com.shop.customerserviceapi.utill.responce.CustomResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(path = "/register")
    public ResponseEntity<CustomResponce> createCustomer(@RequestBody CustomerDto customerDto){


        Customer customer=customerService.createCustomer(customerDto);


        return new ResponseEntity<>(
            new CustomResponce(customer,201,"Success",true),
            HttpStatus.OK
        );


    }



    @GetMapping(path = "/getById/{customerId}")
    public ResponseEntity<CustomResponce> findCustomerById(@PathVariable String customerId){


        CustomCustomerResponce customCustomerResponce=customerService.getCustomerById(customerId);

        return new ResponseEntity<>(
                new CustomResponce(customCustomerResponce,200,"Fetch Success Customer Data",true),
                HttpStatus.OK
        );



    }


    /**
     *
     * @param customerId
     * @return

    @GetMapping(path = "/getCustomerOrders/{customerId}")
    public ResponseEntity<CustomResponce> findOrdersByCustomerId(@PathVariable String customerId){


        List<OrderDto> orderList=customerService.findOrders(customerId);


        return new ResponseEntity<>(
                new CustomResponce(orderList,200,"Fetch Success Order Data",true),
                HttpStatus.OK
        );


    }

     */









}
