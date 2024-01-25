package com.shop.customerserviceapi.Service.impl;

import com.shop.customerserviceapi.Service.CustomerService;
import com.shop.customerserviceapi.dto.CustomerDto;
import com.shop.customerserviceapi.entity.Customer;
import com.shop.customerserviceapi.repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }



    public Customer createCustomer(CustomerDto dtos) {
        Customer customer = new Customer(generateRandomId(), dtos.getName(), dtos.getAddress(), dtos.getSalary());
        customerRepo.save(customer);
        return customer;
    }

    private long generateRandomId() {
        Random random = new Random();
        long randomLong = random.nextLong();
        return Math.abs(randomLong % 1_000_000_000L); // Ensures a positive 10-digit number
    }
}
