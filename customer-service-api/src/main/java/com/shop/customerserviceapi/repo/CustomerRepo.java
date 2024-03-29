package com.shop.customerserviceapi.repo;

import com.shop.customerserviceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {



    @Query(value = "SELECT * FROM customers WHERE id=:customerId",nativeQuery = true)
    Customer getCustomerById(String customerId);


}
