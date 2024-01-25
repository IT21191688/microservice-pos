package com.shop.customerserviceapi.Service;


import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public Customer createCustomer(CustomerDto dtos);
}
