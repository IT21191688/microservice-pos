package com.shop.orderserviceapi.repo;

import com.shop.orderserviceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;


@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,String> {


    @Query(value = "SELECT * FROM orders WHERE customer_id =:id",nativeQuery = true)
    List<Order> getOrderByCustomer(@Param("id") String id);

}
