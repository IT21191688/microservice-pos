package com.shop.customerserviceapi.controller;


import com.shop.customerserviceapi.Service.CustomerService;
import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.entity.Customer;
import com.shop.customerserviceapi.utill.responce.CustomResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
