package com.shop.customerserviceapi.Service;


import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.dto.OrderDto;
import com.shop.customerserviceapi.entity.Customer;
import com.shop.customerserviceapi.utill.responce.CustomCustomerResponce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public Customer createCustomer(CustomerDto dtos);

    public CustomCustomerResponce getCustomerById(String customerId);

    //private List<OrderDto> findOrders(String id);
}
